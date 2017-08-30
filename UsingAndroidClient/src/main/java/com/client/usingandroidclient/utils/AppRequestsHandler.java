package com.client.usingandroidclient.utils;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.client.usingandroidclient.DataManager;
import com.client.usingandroidclient.SessionManager;
import com.client.usingandroidclient.model.MgUserAsset;
import com.kaltura.client.APIOkRequestsExecutor;
import com.kaltura.client.enums.PinType;
import com.kaltura.client.services.AppTokenService;
import com.kaltura.client.services.OttUserService;
import com.kaltura.client.services.PinService;
import com.kaltura.client.services.SessionService;
import com.kaltura.client.types.APIException;
import com.kaltura.client.types.AppToken;
import com.kaltura.client.types.Asset;
import com.kaltura.client.types.LoginResponse;
import com.kaltura.client.types.OTTUser;
import com.kaltura.client.types.Session;
import com.kaltura.client.utils.request.BaseRequestBuilder;
import com.kaltura.client.utils.request.MultiRequestBuilder;
import com.kaltura.client.utils.request.RequestBuilder;
import com.kaltura.client.utils.response.OnCompletion;
import com.kaltura.client.utils.response.base.Response;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tehila.rozin on 8/8/17.
 */

public class AppRequestsHandler {

    public static void main(String... args){
        APIOkRequestsExecutor.getExecutor().queue(
        new SessionApi().userLogin("albert@gmail.com", "123456", new OnCompletion<Response<OTTUser>>() {
            @Override
            public void onComplete(Response<OTTUser> result) {
                if(result.isSuccess()){

                }
            }
        }).
    }

    interface IRequestProvider<T extends BaseRequestBuilder> {
        T get(/*Object ... args*/);
    }

    abstract class RequestType /*implements IRequestProvider*/{
        Object[] args;

        public RequestType() {
        }

        RequestType(Object ... args){
            this.args = args;
        }
    }

    static class SessionApi extends RequestType {

        public RequestBlock<Response<OTTUser>> userLogin(String username, String password/*, OnCompletion<Response<OTTUser>> completion*/) {
            RequestBuilder loginReq = OttUserService.login(198, (String) args[0], (String) args[1]);
            RequestBlock<Response<OTTUser>> x = RequestBlock.get().with(loginReq.add(SessionService.get()).link(0, 1,
                    "loginSession.ks", "ks").add(AppTokenService.add(new AppToken()))
                    .link(1, 2, "expiry", "expiry")
                    .setCompletion(new OnCompletion<Response<List<Object>>>() {
                        @Override
                        public void onComplete(Response<List<Object>> result) {
                            OTTUser user = null;
                            if (result.isSuccess()) {
                                LoginResponse loginResponse = (LoginResponse) result.results.get(0);
                                user = loginResponse.getUser();
                                Object appToken = result.results.get(2);
                                SessionManager.get().updateSession(user.getId(),
                                        loginResponse.getLoginSession().getKs(),
                                        appToken instanceof APIException ? null : (AppToken) appToken);
                            }

                            if (completion != null) {
                                completion.onComplete(new Response<>(user, result.error));
                            }
                        }
                    })).setCompletion(completion);

            x.setCompletion(new OnCompletion<Response<OTTUser>>() {
                @Override
                public void onComplete(Response<OTTUser> result) {

                }
            })

            return x;
        }

    }

    /*
    * CancleToken instead of string cancel
    * */

    /*class SessionType extends RequestType{
        public SessionType() {
            super();
        }

        @Override
        public RequestBuilder get() {
            return SessionService.get();
        }
    }


    class SessionLogin extends RequestType{
        public SessionLogin(String username, String password) {
            super(username, password);
        }

        @Override
        public MultiRequestBuilder get() {
            RequestBuilder loginReq = OttUserService.login(198, (String)args[0], (String)args[1]);
            return loginReq.add(SessionService.get()).link(0, 1, "loginSession.ks", "ks");
        }
    }*/

    public RequestBlock pinCodeValidation(String pinCode, int ruleId, String assetId, OnCompletion<MgUserAsset> completion){
        return RequestBlock.get().with(PinService.validate(pinCode, PinType.PARENTAL, ruleId).setCompletion(
                new OnCompletion<Response<Boolean>>() {
                    @Override
                    public void onComplete(Response<Boolean> result) {
                        if(result.isSuccess() && result.results){
                            detailedAsset(assetId, completion);
                        } else if(completion != null) {
                            completion.onComplete(null);
                        }
                    }
                }
        ));
    }

    //public void


    public RequestBlock sessionLogin(String username, String password, OnCompletion<OTTUser> completion) {

         //RequestBlock.get().with(new SessionLogin("albert", "123456").get()).;


        RequestBuilder loginReq = OttUserService.login(198, username, password);
        MultiRequestBuilder multiRequestBuilder = loginReq.add(SessionService.get()).link(0, 1, "loginSession.ks", "ks");

        return RequestBlock.get().with(multiRequestBuilder);


    }

    public static IAppRequest loginRequestPrx(String username, String password, OnCompletion<OTTUser> completion) {
        return (IAppRequest) RequestBuilderProxy.newInstance(OttUserService.login(198, username, password)

                .setCompletion(new OnCompletion<Response<LoginResponse>>() {
                    @Override
                    public void onComplete(Response<LoginResponse> result) {
                        if(completion != null){
                            completion.onComplete(result.results.getUser());
                        }
                    }
                }));

    }

    public AppRequest loginRequest(String username, String password, OnCompletion<OTTUser> completion) {
        return new AppRequest(DataManager.DataAction.Login)
                .addArg("username", username)
                .addArg("password", password)
                .setCompletion(completion);
    }

    public AppRequest assetRequest(String assetId, OnCompletion<Asset> completion) {
        return new AppRequest(DataManager.DataAction.AssetInfo)
                .addArg("assetId", assetId)
                .setCompletion(completion);
    }

    public AppRequest searchAssetsRequest(List<Integer> types, String sqlFilter, int pageIndex, OnCompletion<Asset> completion) {
        AppRequest seAppRequest = new AppRequest(DataManager.DataAction.AssetList)
                .addArg("filter", sqlFilter)
                .addArg("pageSize", 50 )
                .addArg("pageIndex", pageIndex )
                .setCompletion(completion);

        if(types != null) {
            seAppRequest.addArg("typeIn", Stream.of(types).map(String::valueOf).collect(Collectors.joining(", ")));
        }

        return seAppRequest;
    }

    void appRequestLinkTest(){
        AppRequest searchReq = searchAssetsRequest(Arrays.asList(420), "", 1, new OnCompletion<Asset>() {
            @Override
            public void onComplete(Asset result) {

            }
        });

        AppRequest sessionLogin = loginRequest("", "", new OnCompletion<OTTUser>() {
            @Override
            public void onComplete(OTTUser result) {

            }
        });

        searchReq.link("ks", sessionLogin, "loginSession.ks");
    }



    public static AppRequest assetRequestPrx(String assetId, OnCompletion<Asset> completion) {
        return new AppRequest(DataManager.DataAction.AssetInfo)
                .addArg("assetId", assetId)
                .setCompletion(completion);

    }

    public AppRequestList multirequest(AppRequest... appRequests){
        return new AppRequestList(appRequests);
    }

    public AppRequestList multi(){
        AppRequest login = loginRequest("albert", "123456", null);
        AppRequest multireq = login.concat(

                assetRequest("6576576", null).link("ks", login, "loginSession.ks"));

        AppRequest assetRequest = assetRequest("6576576", null);
        multirequest(login, assetRequest);


        OttUserService.login(198, "", "").setCompletion();
    }
}

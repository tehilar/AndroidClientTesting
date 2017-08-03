package com.client.usingandroidclient;

import android.os.Looper;

import com.kaltura.client.APIOkRequestsExecutor;
import com.kaltura.client.AndroidAPIRequestsExecutor;
import com.kaltura.client.Client;
import com.kaltura.client.Logger;
import com.kaltura.client.enums.AssetReferenceType;
import com.kaltura.client.services.AssetService;
import com.kaltura.client.services.OttUserService;
import com.kaltura.client.services.SessionService;
import com.kaltura.client.types.APIException;
import com.kaltura.client.types.Asset;
import com.kaltura.client.types.LoginResponse;
import com.kaltura.client.types.OTTUser;
import com.kaltura.client.types.Session;
import com.kaltura.client.utils.request.RequestBuilder;
import com.kaltura.client.utils.response.OnCompletion;
import com.kaltura.client.utils.response.base.ApiCompletion;
import com.kaltura.client.utils.response.base.Response;

import junit.framework.Assert;

import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by tehila.rozin on 7/27/17.
 */

public class APICaller {




    public void init(){

    }


    public static void login(final Client client, String username, String password, final OnCompletion<Response<OTTUser>> onCompletion){
        RequestBuilder<Session> session = SessionService.get();
        RequestBuilder<LoginResponse> login = OttUserService.login(client.getPartnerId(),
                username, password);

        AndroidAPIRequestsExecutor.getExecutor().queue(login.add(session).link(login, session, "loginSession.ks", "ks")
                .setCompletion(new ApiCompletion<List<Object>>() {

                    @Override
                    public void onComplete(Response<List<Object>> result) {
                        Logger.getLogger("clientLib-testing").debug("login completion");

                        assertTrue(Looper.myLooper() == Looper.getMainLooper());

                        if (onCompletion != null) {
                            OTTUser user = null;
                            APIException error = null;
                            if (result.results.get(0) instanceof APIException) {
                                error = ((APIException) result.results.get(0));
                            } else {
                                try {
                                    LoginResponse loginResponse = (LoginResponse) result.results.get(0);
                                    user = loginResponse.getUser();
                                    client.setKs(loginResponse.getLoginSession().getKs());
                                } catch (ClassCastException e) {
                                    error = result.error != null ? result.error : new APIException(APIException.FailureStep.OnResponse, e);
                                }
                                onCompletion.onComplete(new Response<OTTUser>(user, error));
                            }

                            APIOkRequestsExecutor.getExecutor().queue(OttUserService.updatePassword(/*Integer.parseInt(user.getId())*/0, "123456")
                                    .setCompletion(new OnCompletion<Response<Void>>() {
                                        @Override
                                        public void onComplete(Response<Void> result) {
                                            Logger.getLogger("clientLib-testing").debug("password update completion");
                                            Assert.assertTrue(Looper.myLooper() != Looper.getMainLooper());

                                        }
                                    }).build(client));

                            try {
                                Session session1 = (Session) result.results.get(1);
                                int expiry = session1.getExpiry();
                            } catch (ClassCastException e) {
                                error = new APIException(APIException.FailureStep.OnResponse, e);
                            }

                            getAsset(client, "258656", new OnCompletion<Asset>() {
                                @Override
                                public void onComplete(Asset result) {
                                    Assert.assertTrue(Looper.myLooper() == Looper.getMainLooper());

                                    APIOkRequestsExecutor.getExecutor().queue(
                                            AssetService.get("258656", AssetReferenceType.MEDIA).setCompletion(
                                                    new OnCompletion<Response<Asset>>() {
                                                        @Override
                                                        public void onComplete(Response<Asset> result) {
                                                            Response<Asset> response = (Response<Asset>) AndroidAPIRequestsExecutor.getBackExecutor().execute(AssetService.get("258656", AssetReferenceType.MEDIA).build(client));
                                                            Assert.assertTrue(Looper.myLooper() != Looper.getMainLooper());
                                                        }
                                                    }).build(client));
                                }
                            });
                        }
                    }
                }).build(client));
    }

    public static void getAsset(final Client client, String assetId, final OnCompletion<Asset> completion) {
        AndroidAPIRequestsExecutor.getExecutor().queue(AssetService.get(assetId, AssetReferenceType.MEDIA)
                .setCompletion(new OnCompletion<Response<Asset>>() {
                    @Override
                    public void onComplete(Response<Asset> result) {

                        if( completion != null){
                            completion.onComplete(result.isSuccess() ? result.results : null);
                        }

                    }
                }).build(client));
    }
}

package com.client.usingandroidclient;

import com.kaltura.client.APIOkRequestsExecutor;
import com.kaltura.client.Client;
import com.kaltura.client.Logger;
import com.kaltura.client.services.OttUserService;
import com.kaltura.client.services.SessionService;
import com.kaltura.client.types.LoginResponse;
import com.kaltura.client.types.OTTUser;
import com.kaltura.client.types.Session;
import com.kaltura.client.utils.request.RequestBuilder;
import com.kaltura.client.utils.response.OnCompletion;
import com.kaltura.client.utils.response.base.ApiCompletion;
import com.kaltura.client.utils.response.base.Response;

/**
 * Created by tehila.rozin on 7/27/17.
 */

public class APICaller {




    public void init(){

    }


    public static void login(Client client, String username, String password, final OnCompletion<Response<OTTUser>> onCompletion){
        RequestBuilder<Session> session = SessionService.get();
        RequestBuilder<LoginResponse> login = OttUserService.login(client.getPartnerId(),
                username, password);

        APIOkRequestsExecutor.getExecutor().queue(login.add(session).link(login, session, "loginSession.ks", "ks")
                .setCompletion(new ApiCompletion<Object>() {

                    @Override
                    public void onComplete(Response<Object> result) {
                        Logger.getLogger("shit").debug("here");

                        /*if(onCompletion != null){
                            onCompletion.onComplete(result);
                        }*/
                    }
                }).build(client));

               /*


                setCompletion(new OnCompletion<LoginResponse>() {
            @Override
            public void onComplete(LoginResponse response, APIException error) {
                if(error==null && response!=null){
                    SessionManager.get().updateSession(response.getUser().getId(),
                            response.getLoginSession().getKs(),
                            response.getLoginSession().);
                }
            }
        }))*/
    }
}

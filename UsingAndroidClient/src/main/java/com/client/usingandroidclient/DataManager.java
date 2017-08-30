package com.client.usingandroidclient;

import android.support.annotation.StringDef;

import com.kaltura.client.utils.request.MultiRequestBuilder;
import com.kaltura.client.utils.request.RequestBuilder;
import com.kaltura.client.utils.response.OnCompletion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.client.usingandroidclient.DataManager.DataAction.AnonymousLogin;
import static com.client.usingandroidclient.DataManager.DataAction.AssetInfo;
import static com.client.usingandroidclient.DataManager.DataAction.Login;
import static com.client.usingandroidclient.DataManager.DataAction.SessionInfo;
import static com.client.usingandroidclient.DataManager.DataAction.UserInfo;

/**
 * Created by tehila.rozin on 8/6/17.
 */

public class DataManager {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({AssetInfo, AssetInfo, SessionInfo, UserInfo, Login, AnonymousLogin})
    public @interface DataAction {
        String AssetInfo = "service/asset/action/get";
        String AssetList = "service/asset/action/list"; //pageIndex starts from 1
        String SessionInfo = "service/session/action/get";
        String UserInfo = "service/ottUser/action/get";
        String Login = "service/ottUser/action/login";
        String AnonymousLogin = "service/ottUser/action/anonymousLogin";
        String Multirequest = "service/multirequest";
    }

    /*@Retention(RetentionPolicy.SOURCE)
    @StringDef({AssetInfo, AssetInfo, SessionInfo, UserInfo, Login, AnonymousLogin})
    @interface tpDataAction {
        String AssetInfo = "service/asset/action/get";
        String AssetList = "service/asset/action/list";
        String SessionInfo = "service/session/action/get";
        String UserInfo = "service/ottUser/action/get";
        String Login = "service/ottUser/action/login";
        String AnonymousLogin = "service/ottUser/action/anonymousLogin";
    }*/

    interface RequestProvider{
        String getAction();
        Object[] getArgs();

    }

    class MGRequest implements RequestProvider{

        @DataAction String action;

        Object[] args;

        OnCompletion callback;

        Object[] stickyData;




        public MGRequest(@tpDataAction@DataAction String action) {
            this.action = action;
        }

        public void addTo(MGRequest another){}


        public MGRequest args(Object... args) {
            this.args = args;
            return this;
        }

        @Override
        public String getAction() {
            return this.action;
        }

        @Override
        public Object[] getArgs() {
            return this.args;
        }
    }

    /*public static String getAssetInfo(String assetId, int type, OnCompletion onCompletion){
        new MGRequest(DataAction.AnonymousLogin);
    }

    public static void getLoginRequest(String userName, String password, OnCompletion callback){
        new MGRequest(DataAction.Login).args(userName, password).callback(callback){
            @Override
            public MGRequest args(Object... args) {
                return super.args(args);
            }
        }
    }*/

    class fun{
        private void havingFun(){

            /*new MGRequest(DataAction.Login).args("albert", "123456").stick(getClass().getName()).add(new MGRequest(DataAction.SessionInfo)).callback(
                    new OnCompletion<List<Object>>() {
                        @Override
                        public void onComplete(List<Object> result) {

                        }
                    }
            ).build();
*/


        }
    }



    class builder{
        RequestBuilder requestBuilder;

        MultiRequestBuilder multiRequestBuilder;
    }

}

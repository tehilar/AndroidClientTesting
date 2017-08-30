package com.client.usingandroidclient.utils;

import com.kaltura.client.utils.response.OnCompletion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tehila.rozin on 8/8/17.
 */

public class AppRequest implements IAppRequest {


    String action;

    Map<String, Object> args;

    Map<String, AppRequest> links;

    OnCompletion<?> completion;


    public AppRequest(String action) {
        this.action = action;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public Map<String, Object> getParams() {
        return null;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    /*public AppRequest setArgs(Map<String, Object> args) {
        if(this.args == null){
            this.args = new HashMap<>();
        } else {
            this.args.clear();
        }
        args.putAll(args);
        return this;
    }*/

    public AppRequest addArg(String key, Object arg){
        if(this.args == null){
            this.args = new HashMap<>();
        }
        this.args.put(key, arg);
        return this;
    }


    public OnCompletion<?> getCompletion() {
        return completion;
    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public String executeBlocking() {
        return null;
    }

    @Override
    public <T extends IAppRequest> T  setCompletion(OnCompletion<?> completion) {
        this.completion = completion;
        return (T) this;
    }

    @Override
    public AppRequest add(IAppRequest appRequest){
        return new AppRequestList(this, appRequest);
    }

    public AppRequest link(String key, AppRequest destRequest, String responseKey){
        key = "link\\" + key + "\\to\\" + responseKey;
        links.put(key, destRequest);
        return this.addArg(key, "link:"+responseKey);
    }
}

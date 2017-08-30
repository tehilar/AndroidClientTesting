package com.client.usingandroidclient.utils;

import com.kaltura.client.utils.response.OnCompletion;

/**
 * Created by tehila.rozin on 8/8/17.
 */

public class RequestBlock<RT> {

    Object request;

    //String action;


//!! TODO how to cancel

    OnCompletion<?> completion;

    /*Map<String, Object> args;

    Map<String, RequestBlock> links;

    OnCompletion<?> completion;*/

    public RequestBlock() {
    }

    public static RequestBlock get() {  //"service/ottUser/action/login"
        return new RequestBlock();
    }

    public RequestBlock<RT> with(Object requestBuilder){
        /*if(this.requestBuilder != null){
            this.requestBuilder =  this.requestBuilder.add(requestBuilder);
        } else {*/
            this.request = requestBuilder;
        //}
        return this;
    }

    /*public RequestBlock with(RequestBuilder requestBuilder){
        *//*if(this.requestBuilder != null){
            this.requestBuilder =  this.requestBuilder.add(requestBuilder);
        } else {*//*
            this.requestBuilder = requestBuilder;
        //}
        return this;
    }*/

    /*public String getAction() {
        return action;
    }*/

    public RequestBlock setCompletion(OnCompletion<RT> completion) {
        this.completion = completion;
        return this;
    }

}

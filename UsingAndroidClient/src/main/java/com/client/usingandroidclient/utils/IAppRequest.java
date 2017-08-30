package com.client.usingandroidclient.utils;

import com.kaltura.client.utils.response.OnCompletion;

import java.util.Map;

/**
 * Created by tehila.rozin on 8/8/17.
 */

interface IAppRequest {

    String getAction();

    Map<String, Object> getParams();

    <T extends IAppRequest> T setCompletion(OnCompletion<?> completion);

    String execute();

    String executeBlocking();

    IAppRequest add(IAppRequest request);
}

package com.kaltura.client.utils.response.base;

import android.os.Handler;

import com.kaltura.client.utils.ErrorElement;


/**
 * Created by tehilarozin on 06/09/2016.
 */
public interface ResponseElement {

    int getCode();

    String getResponse();

    boolean isSuccess();

    String getRequestId();

    ErrorElement getError();

    Handler getHandler();

}

package com.client.usingandroidclient.utils;

import com.kaltura.client.types.ObjectBase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tehila.rozin on 8/8/17.
 */

public class RequestBuilderProxy<T> implements InvocationHandler {

    private final Object req;

    public RequestBuilderProxy(Object req) {
        this.req = req;
    }

    public static <T extends ObjectBase> Object newInstance(Object req){
        return Proxy.newProxyInstance(IAppRequest.class.getClassLoader(),
                new Class[]{IAppRequest.class},
                new RequestBuilderProxy<T>(req));
    }

    /*
    *
    * Asset.metas.0.genre
    *
    * */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try{
            method.invoke(req, args);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex){
            ex.printStackTrace();
        }
        return null;
    }
}

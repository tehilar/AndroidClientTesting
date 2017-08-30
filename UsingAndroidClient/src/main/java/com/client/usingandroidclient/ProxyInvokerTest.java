package com.client.usingandroidclient;

import com.client.usingandroidclient.model.IAsset;
import com.client.usingandroidclient.model.ISeries;
import com.kaltura.client.APIOkRequestsExecutor;
import com.kaltura.client.enums.AssetType;
import com.kaltura.client.services.AssetService;
import com.kaltura.client.types.Asset;
import com.kaltura.client.types.FilterPager;
import com.kaltura.client.types.ListResponse;
import com.kaltura.client.types.SearchAssetFilter;
import com.kaltura.client.utils.response.OnCompletion;
import com.kaltura.client.utils.response.base.Response;

import org.awaitility.Awaitility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tehila.rozin on 8/7/17.
 */
/*
* app requests builder
* adding support to DataManager to receive app requests
*
* */
public class ProxyInvokerTest {

    private static AtomicBoolean callDone = new AtomicBoolean(false);

    public static void main(String...args){

        SearchAssetFilter searchAssetFilter = new SearchAssetFilter();
        searchAssetFilter.setTypeIn(AssetType.MEDIA.getValue());
        FilterPager filterPager = new FilterPager();
        filterPager.setPageIndex(0);
        filterPager.setPageSize(30);
        APIOkRequestsExecutor.getExecutor().queue(AssetService.list(searchAssetFilter, filterPager).setCompletion(
                new OnCompletion<Response<ListResponse<Asset>>>() {
                    @Override
                    public void onComplete(Response<ListResponse<Asset>> result) {
                        ISeries series = (ISeries)AssetProxy.newInstance(result.results.getObjects().get(0), IAsset.class, ISeries.class);
                        series.getSeasonCount();
                        callDone.set(true);
                    }
                }
        ).build(SessionManager.get().getClient()));

        Awaitility.await().untilTrue(callDone);
    }

    static class AssetProxy<T extends Asset> implements InvocationHandler {

        private T asset;
        private Map<String, Object> map;
        // declare at run time which interfaces are supported.
        public static <T extends Asset> Object newInstance(T asset, Class... interfaces){
            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    interfaces,
                    new AssetProxy(asset));
        }

        public AssetProxy(T asset) {
            this.asset = asset;
            this.map = new HashMap<>();
        }

        /**
         *
         * @param proxy - the proxy instance that created the object which called this invoke
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {

                // try to invoke the requested method on the given direct object
                return method.invoke(asset, args);
            } catch (IllegalArgumentException e)
            { // ignore }

                // if method invocation failed implement self invoker:
                // setXXX will save the value, while getXXX will retrieve it from from the saved values.
                // if wasn't saved yet, return null.
                Object result;
                String methodName = method.getName();
                if (methodName.startsWith("get"))
                {
                    String name = methodName.substring(methodName.indexOf("get")+3);
                    return map.get(name);
                }
                else if (methodName.startsWith("set"))
                {
                    String name = methodName.substring(methodName.indexOf("set")+3);
                    map.put(name, args[0]);
                    return null;
                }
                else if (methodName.startsWith("is"))
                {
                    String name = methodName.substring(methodName.indexOf("is")+2);
                    return(map.get(name));
                }
                return null;
            }
        }
    }



    static class AssetProxy1 implements InvocationHandler {

        private Map map;
        private Object obj;

        // declare at run time which interfaces are supported.
        public static Object newInstance(Map map, Object obj, Class... interfaces){
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                    interfaces,
                    new AssetProxy1(map, obj));
        }

        public AssetProxy1(Map map, Object obj) {
            this.map = map;
            this.obj = obj;
        }

        /**
         *
         * @param proxy - the proxy instance that created the object which called this invoke
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {

                // try to invoke the requested method on the given direct object
                return method.invoke(obj, args);
            } catch (IllegalArgumentException e)
            { // ignore }

                // if method invokation failed implement self invoker:
                // setXXX will save the value, while getXXX will retrieve it from from the saved values.
                // if wasn't saved yet, return null.
                Object result;
                String methodName = method.getName();
                if (methodName.startsWith("get"))
                {
                    String name = methodName.substring(methodName.indexOf("get")+3);
                    return map.get(name);
                }
                else if (methodName.startsWith("set"))
                {
                    String name = methodName.substring(methodName.indexOf("set")+3);
                    map.put(name, args[0]);
                    return null;
                }
                else if (methodName.startsWith("is"))
                {
                    String name = methodName.substring(methodName.indexOf("is")+2);
                    return(map.get(name));
                }
                return null;
            }
        }
    }

}

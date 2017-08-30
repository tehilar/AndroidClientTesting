package com.client.usingandroidclient.utils;

import com.client.usingandroidclient.DataManager;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by tehila.rozin on 8/8/17.
 */

public class AppRequestList extends AppRequest {

    LinkedList<IAppRequest> requests;

    public AppRequestList(String action) {
        super(action);

        requests = new LinkedList<>();
    }

    public AppRequestList(IAppRequest...requests) {
        super(DataManager.DataAction.Multirequest);

        this.requests = new LinkedList<IAppRequest>(Arrays.asList(requests));
    }

    @Override
    public AppRequestList add(IAppRequest request){
        requests.add(request);
        return this;
    }

    /*public AppRequestList addRequestAsLinked(AppRequest request, int targetIndex, String linkedKey){

    }*/
}

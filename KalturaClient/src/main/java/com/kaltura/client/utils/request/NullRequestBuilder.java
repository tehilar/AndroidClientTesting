package com.kaltura.client.utils.request;

import com.kaltura.client.Params;
import com.kaltura.client.utils.response.base.Response;

public class NullRequestBuilder extends RequestBuilder<Void> {

    public NullRequestBuilder() {
    	super(Void.class);
    }

    public NullRequestBuilder(String service, String action, Params params) {
        super(Void.class, service, action, params);
    }

    @Override
    protected void complete(Response<Void> response) {
        super.complete(response.results(null));
    }
}















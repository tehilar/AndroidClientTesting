package com.client.usingandroidclient;

import com.kaltura.client.Client;
import com.kaltura.client.Configuration;
import com.kaltura.client.types.AppToken;

/**
 * Created by tehila.rozin on 7/27/17.
 */

public class SessionManager {

    Client client;

    private static SessionManager self;
    private AppToken appToken;

    public static SessionManager get(){
        if(self == null){
            self = new SessionManager();
        }

        return self;
    }

    private SessionManager(){
        Configuration configuration = new Configuration();
        configuration.setEndpoint("https://api-preprod.ott.kaltura.com/v4_5");
        client = new Client(configuration);
        client.setPartnerId(198);
    }

    public void updateSession(String userId, String ks, AppToken appToken){
        client.setUserId(Integer.valueOf(userId));
        client.setKs(ks);
        this.appToken = appToken;
    }

    public Client getClient() {
        return client;
    }
}

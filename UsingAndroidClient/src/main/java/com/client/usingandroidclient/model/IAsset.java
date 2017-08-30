package com.client.usingandroidclient.model;

import java.util.Date;

/**
 * Created by tehila.rozin on 8/7/17.
 */

public interface IAsset {
    String getName();
    String getDescription();
    long getDuration();
    Date getStartTime();

    void setName(String name);
}

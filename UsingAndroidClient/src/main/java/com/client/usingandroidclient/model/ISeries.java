package com.client.usingandroidclient.model;

/**
 * Created by tehila.rozin on 8/7/17.
 */

public interface ISeries extends IAsset {

    int getSeasonCount();
    int getEpisodeCount(int seasonNumber);
}

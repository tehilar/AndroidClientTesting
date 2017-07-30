package com.client.usingandroidclient.model;

import com.kaltura.client.types.Asset;
import com.kaltura.client.types.AssetStatistics;
import com.kaltura.client.types.Bookmark;

import java.util.List;

/**
 * Created by tehila.rozin on 7/27/17.
 */

public class MgUserAsset extends Asset {

    List<Bookmark> bookmarks; //bookmark/list
    List<AssetStatistics> statistics; // assetStatistics/query
    List<Asset> related;//asset/list with relatedFilter

}

// ===================================================================================================
//                           _  __     _ _
//                          | |/ /__ _| | |_ _  _ _ _ __ _
//                          | ' </ _` | |  _| || | '_/ _` |
//                          |_|\_\__,_|_|\__|\_,_|_| \__,_|
//
// This file is part of the Kaltura Collaborative Media Suite which allows users
// to do with audio, video, and animation what Wiki platfroms allow them to do with
// text.
//
// Copyright (C) 2006-2017  Kaltura Inc.
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
// @ignore
// ===================================================================================================
package com.kaltura.client.types;

import android.os.Parcel;
import com.google.gson.JsonObject;
import com.kaltura.client.Params;
import com.kaltura.client.enums.AssetType;
import com.kaltura.client.utils.GsonParser;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class SocialFriendActivityFilter extends Filter {

	/**  Asset ID to filter by  */
    private Long assetIdEqual;
	/**  Asset type to filter by, currently only VOD (media)  */
    private AssetType assetTypeEqual;
	/**  Comma separated list of social actions to filter by  */
    private String actionTypeIn;

    // assetIdEqual:
    public Long getAssetIdEqual(){
        return this.assetIdEqual;
    }
    public void setAssetIdEqual(Long assetIdEqual){
        this.assetIdEqual = assetIdEqual;
    }

    // assetTypeEqual:
    public AssetType getAssetTypeEqual(){
        return this.assetTypeEqual;
    }
    public void setAssetTypeEqual(AssetType assetTypeEqual){
        this.assetTypeEqual = assetTypeEqual;
    }

    // actionTypeIn:
    public String getActionTypeIn(){
        return this.actionTypeIn;
    }
    public void setActionTypeIn(String actionTypeIn){
        this.actionTypeIn = actionTypeIn;
    }


    public SocialFriendActivityFilter() {
       super();
    }

    public SocialFriendActivityFilter(JsonObject jsonObject) throws APIException {
        super(jsonObject);

        if(jsonObject == null) return;

        // set members values:
        assetIdEqual = GsonParser.parseLong(jsonObject.get("assetIdEqual"));
        assetTypeEqual = AssetType.get(GsonParser.parseString(jsonObject.get("assetTypeEqual")));
        actionTypeIn = GsonParser.parseString(jsonObject.get("actionTypeIn"));

    }

    public Params toParams() {
        Params kparams = super.toParams();
        kparams.add("objectType", "KalturaSocialFriendActivityFilter");
        kparams.add("assetIdEqual", this.assetIdEqual);
        kparams.add("assetTypeEqual", this.assetTypeEqual);
        kparams.add("actionTypeIn", this.actionTypeIn);
        return kparams;
    }


    public static final Creator<SocialFriendActivityFilter> CREATOR = new Creator<SocialFriendActivityFilter>() {
        @Override
        public SocialFriendActivityFilter createFromParcel(Parcel source) {
            return new SocialFriendActivityFilter(source);
        }

        @Override
        public SocialFriendActivityFilter[] newArray(int size) {
            return new SocialFriendActivityFilter[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeValue(this.assetIdEqual);
        dest.writeInt(this.assetTypeEqual == null ? -1 : this.assetTypeEqual.ordinal());
        dest.writeString(this.actionTypeIn);
    }

    public SocialFriendActivityFilter(Parcel in) {
        super(in);
        this.assetIdEqual = (Long)in.readValue(Long.class.getClassLoader());
        int tmpAssetTypeEqual = in.readInt();
        this.assetTypeEqual = tmpAssetTypeEqual == -1 ? null : AssetType.values()[tmpAssetTypeEqual];
        this.actionTypeIn = in.readString();
    }
}


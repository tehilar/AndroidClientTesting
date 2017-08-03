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
import com.kaltura.client.enums.WatchStatus;
import com.kaltura.client.utils.GsonParser;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class AssetHistoryFilter extends Filter {

	/**  Comma separated list of asset types to search within.              Possible
	  values: 0 – EPG linear programs entries, any media type ID (according to media
	  type IDs defined dynamically in the system).              If omitted – all
	  types should be included.  */
    private String typeIn;
	/**  Comma separated list of asset identifiers.  */
    private String assetIdIn;
	/**  Which type of recently watched media to include in the result – those that
	  finished watching, those that are in progress or both.              If omitted
	  or specified filter = all – return all types.              Allowed values:
	  progress – return medias that are in-progress, done – return medias that
	  finished watching.  */
    private WatchStatus statusEqual;
	/**  How many days back to return the watched media. If omitted, default to 7 days  */
    private Integer daysLessThanOrEqual;

    // typeIn:
    public String getTypeIn(){
        return this.typeIn;
    }
    public void setTypeIn(String typeIn){
        this.typeIn = typeIn;
    }

    // assetIdIn:
    public String getAssetIdIn(){
        return this.assetIdIn;
    }
    public void setAssetIdIn(String assetIdIn){
        this.assetIdIn = assetIdIn;
    }

    // statusEqual:
    public WatchStatus getStatusEqual(){
        return this.statusEqual;
    }
    public void setStatusEqual(WatchStatus statusEqual){
        this.statusEqual = statusEqual;
    }

    // daysLessThanOrEqual:
    public Integer getDaysLessThanOrEqual(){
        return this.daysLessThanOrEqual;
    }
    public void setDaysLessThanOrEqual(Integer daysLessThanOrEqual){
        this.daysLessThanOrEqual = daysLessThanOrEqual;
    }


    public AssetHistoryFilter() {
       super();
    }

    public AssetHistoryFilter(JsonObject jsonObject) throws APIException {
        super(jsonObject);

        if(jsonObject == null) return;

        // set members values:
        typeIn = GsonParser.parseString(jsonObject.get("typeIn"));
        assetIdIn = GsonParser.parseString(jsonObject.get("assetIdIn"));
        statusEqual = WatchStatus.get(GsonParser.parseString(jsonObject.get("statusEqual")));
        daysLessThanOrEqual = GsonParser.parseInt(jsonObject.get("daysLessThanOrEqual"));

    }

    public Params toParams() {
        Params kparams = super.toParams();
        kparams.add("objectType", "KalturaAssetHistoryFilter");
        kparams.add("typeIn", this.typeIn);
        kparams.add("assetIdIn", this.assetIdIn);
        kparams.add("statusEqual", this.statusEqual);
        kparams.add("daysLessThanOrEqual", this.daysLessThanOrEqual);
        return kparams;
    }


    public static final Creator<AssetHistoryFilter> CREATOR = new Creator<AssetHistoryFilter>() {
        @Override
        public AssetHistoryFilter createFromParcel(Parcel source) {
            return new AssetHistoryFilter(source);
        }

        @Override
        public AssetHistoryFilter[] newArray(int size) {
            return new AssetHistoryFilter[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.typeIn);
        dest.writeString(this.assetIdIn);
        dest.writeInt(this.statusEqual == null ? -1 : this.statusEqual.ordinal());
        dest.writeValue(this.daysLessThanOrEqual);
    }

    public AssetHistoryFilter(Parcel in) {
        super(in);
        this.typeIn = in.readString();
        this.assetIdIn = in.readString();
        int tmpStatusEqual = in.readInt();
        this.statusEqual = tmpStatusEqual == -1 ? null : WatchStatus.values()[tmpStatusEqual];
        this.daysLessThanOrEqual = (Integer)in.readValue(Integer.class.getClassLoader());
    }
}


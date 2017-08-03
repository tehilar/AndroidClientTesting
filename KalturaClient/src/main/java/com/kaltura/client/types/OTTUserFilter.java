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
import com.kaltura.client.utils.GsonParser;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  OTT User filter  */
@SuppressWarnings("serial")
public class OTTUserFilter extends Filter {

	/**  Username  */
    private String usernameEqual;
	/**  User external identifier  */
    private String externalIdEqual;
	/**  List of user identifiers separated by &amp;#39;,&amp;#39;  */
    private String idIn;

    // usernameEqual:
    public String getUsernameEqual(){
        return this.usernameEqual;
    }
    public void setUsernameEqual(String usernameEqual){
        this.usernameEqual = usernameEqual;
    }

    // externalIdEqual:
    public String getExternalIdEqual(){
        return this.externalIdEqual;
    }
    public void setExternalIdEqual(String externalIdEqual){
        this.externalIdEqual = externalIdEqual;
    }

    // idIn:
    public String getIdIn(){
        return this.idIn;
    }
    public void setIdIn(String idIn){
        this.idIn = idIn;
    }


    public OTTUserFilter() {
       super();
    }

    public OTTUserFilter(JsonObject jsonObject) throws APIException {
        super(jsonObject);

        if(jsonObject == null) return;

        // set members values:
        usernameEqual = GsonParser.parseString(jsonObject.get("usernameEqual"));
        externalIdEqual = GsonParser.parseString(jsonObject.get("externalIdEqual"));
        idIn = GsonParser.parseString(jsonObject.get("idIn"));

    }

    public Params toParams() {
        Params kparams = super.toParams();
        kparams.add("objectType", "KalturaOTTUserFilter");
        kparams.add("usernameEqual", this.usernameEqual);
        kparams.add("externalIdEqual", this.externalIdEqual);
        kparams.add("idIn", this.idIn);
        return kparams;
    }


    public static final Creator<OTTUserFilter> CREATOR = new Creator<OTTUserFilter>() {
        @Override
        public OTTUserFilter createFromParcel(Parcel source) {
            return new OTTUserFilter(source);
        }

        @Override
        public OTTUserFilter[] newArray(int size) {
            return new OTTUserFilter[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.usernameEqual);
        dest.writeString(this.externalIdEqual);
        dest.writeString(this.idIn);
    }

    public OTTUserFilter(Parcel in) {
        super(in);
        this.usernameEqual = in.readString();
        this.externalIdEqual = in.readString();
        this.idIn = in.readString();
    }
}


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
import com.kaltura.client.utils.request.MultiRequestBuilder;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  Currency filter  */
@SuppressWarnings("serial")
@MultiRequestBuilder.Tokenizer(CurrencyFilter.Tokenizer.class)
public class CurrencyFilter extends Filter {
	
	public interface Tokenizer extends Filter.Tokenizer {
		String codeIn();
	}

	/**  Currency codes  */
	private String codeIn;

	// codeIn:
	public String getCodeIn(){
		return this.codeIn;
	}
	public void setCodeIn(String codeIn){
		this.codeIn = codeIn;
	}

	public void codeIn(String multirequestToken){
		setToken("codeIn", multirequestToken);
	}


	public CurrencyFilter() {
		super();
	}

	public CurrencyFilter(JsonObject jsonObject) throws APIException {
		super(jsonObject);

		if(jsonObject == null) return;

		// set members values:
		codeIn = GsonParser.parseString(jsonObject.get("codeIn"));

	}

	public Params toParams() {
		Params kparams = super.toParams();
		kparams.add("objectType", "KalturaCurrencyFilter");
		kparams.add("codeIn", this.codeIn);
		return kparams;
	}


    public static final Creator<CurrencyFilter> CREATOR = new Creator<CurrencyFilter>() {
        @Override
        public CurrencyFilter createFromParcel(Parcel source) {
            return new CurrencyFilter(source);
        }

        @Override
        public CurrencyFilter[] newArray(int size) {
            return new CurrencyFilter[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.codeIn);
    }

    public CurrencyFilter(Parcel in) {
        super(in);
        this.codeIn = in.readString();
    }
}


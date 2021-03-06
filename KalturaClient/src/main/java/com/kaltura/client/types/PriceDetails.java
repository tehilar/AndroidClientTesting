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
import com.kaltura.client.types.ObjectBase;
import com.kaltura.client.types.Price;
import com.kaltura.client.utils.GsonParser;
import com.kaltura.client.utils.request.MultiRequestBuilder;
import com.kaltura.client.utils.request.RequestBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  Price details  */
@SuppressWarnings("serial")
@MultiRequestBuilder.Tokenizer(PriceDetails.Tokenizer.class)
public class PriceDetails extends ObjectBase {
	
	public interface Tokenizer extends ObjectBase.Tokenizer {
		String id();
		String name();
		Price.Tokenizer price();
		RequestBuilder.ListTokenizer<Price.Tokenizer> multiCurrencyPrice();
		RequestBuilder.ListTokenizer<TranslationToken.Tokenizer> descriptions();
	}

	/**  The price code identifier  */
	private Integer id;
	/**  The price code name  */
	private String name;
	/**  The price  */
	private Price price;
	/**  Multi currency prices for all countries and currencies  */
	private List<Price> multiCurrencyPrice;
	/**  A list of the descriptions for this price on different languages (language code
	  and translation)  */
	private List<TranslationToken> descriptions;

	// id:
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}

	public void id(String multirequestToken){
		setToken("id", multirequestToken);
	}

	// name:
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public void name(String multirequestToken){
		setToken("name", multirequestToken);
	}

	// price:
	public Price getPrice(){
		return this.price;
	}
	public void setPrice(Price price){
		this.price = price;
	}

	// multiCurrencyPrice:
	public List<Price> getMultiCurrencyPrice(){
		return this.multiCurrencyPrice;
	}
	public void setMultiCurrencyPrice(List<Price> multiCurrencyPrice){
		this.multiCurrencyPrice = multiCurrencyPrice;
	}

	// descriptions:
	public List<TranslationToken> getDescriptions(){
		return this.descriptions;
	}
	public void setDescriptions(List<TranslationToken> descriptions){
		this.descriptions = descriptions;
	}


	public PriceDetails() {
		super();
	}

	public PriceDetails(JsonObject jsonObject) throws APIException {
		super(jsonObject);

		if(jsonObject == null) return;

		// set members values:
		id = GsonParser.parseInt(jsonObject.get("id"));
		name = GsonParser.parseString(jsonObject.get("name"));
		price = GsonParser.parseObject(jsonObject.getAsJsonObject("price"), Price.class);
		multiCurrencyPrice = GsonParser.parseArray(jsonObject.getAsJsonArray("multiCurrencyPrice"), Price.class);
		descriptions = GsonParser.parseArray(jsonObject.getAsJsonArray("descriptions"), TranslationToken.class);

	}

	public Params toParams() {
		Params kparams = super.toParams();
		kparams.add("objectType", "KalturaPriceDetails");
		kparams.add("name", this.name);
		kparams.add("multiCurrencyPrice", this.multiCurrencyPrice);
		kparams.add("descriptions", this.descriptions);
		return kparams;
	}


    public static final Creator<PriceDetails> CREATOR = new Creator<PriceDetails>() {
        @Override
        public PriceDetails createFromParcel(Parcel source) {
            return new PriceDetails(source);
        }

        @Override
        public PriceDetails[] newArray(int size) {
            return new PriceDetails[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.price, flags);
        if(this.multiCurrencyPrice != null) {
            dest.writeInt(this.multiCurrencyPrice.size());
            dest.writeList(this.multiCurrencyPrice);
        } else {
            dest.writeInt(-1);
        }
        if(this.descriptions != null) {
            dest.writeInt(this.descriptions.size());
            dest.writeList(this.descriptions);
        } else {
            dest.writeInt(-1);
        }
    }

    public PriceDetails(Parcel in) {
        super(in);
        this.id = (Integer)in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.price = in.readParcelable(Price.class.getClassLoader());
        int multiCurrencyPriceSize = in.readInt();
        if( multiCurrencyPriceSize > -1) {
            this.multiCurrencyPrice = new ArrayList<>();
            in.readList(this.multiCurrencyPrice, Price.class.getClassLoader());
        }
        int descriptionsSize = in.readInt();
        if( descriptionsSize > -1) {
            this.descriptions = new ArrayList<>();
            in.readList(this.descriptions, TranslationToken.class.getClassLoader());
        }
    }
}


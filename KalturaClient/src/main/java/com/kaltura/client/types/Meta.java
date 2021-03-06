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
import com.kaltura.client.enums.MetaFieldName;
import com.kaltura.client.enums.MetaType;
import com.kaltura.client.types.ObjectBase;
import com.kaltura.client.utils.GsonParser;
import com.kaltura.client.utils.request.MultiRequestBuilder;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  Asset meta  */
@SuppressWarnings("serial")
@MultiRequestBuilder.Tokenizer(Meta.Tokenizer.class)
public class Meta extends ObjectBase {
	
	public interface Tokenizer extends ObjectBase.Tokenizer {
		String name();
		String fieldName();
		String type();
		String assetType();
		String features();
		String id();
		String parentId();
		String partnerId();
	}

	/**  Meta name for the partner  */
	private String name;
	/**  Meta system field name  */
	private MetaFieldName fieldName;
	/**  Meta value type  */
	private MetaType type;
	/**  Asset type this meta is related to  */
	private AssetType assetType;
	/**  List of supported features  */
	private String features;
	/**  Meta id  */
	private String id;
	/**  Parent meta id  */
	private String parentId;
	/**  Partner Id  */
	private Integer partnerId;

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

	// fieldName:
	public MetaFieldName getFieldName(){
		return this.fieldName;
	}
	public void setFieldName(MetaFieldName fieldName){
		this.fieldName = fieldName;
	}

	public void fieldName(String multirequestToken){
		setToken("fieldName", multirequestToken);
	}

	// type:
	public MetaType getType(){
		return this.type;
	}
	public void setType(MetaType type){
		this.type = type;
	}

	public void type(String multirequestToken){
		setToken("type", multirequestToken);
	}

	// assetType:
	public AssetType getAssetType(){
		return this.assetType;
	}
	public void setAssetType(AssetType assetType){
		this.assetType = assetType;
	}

	public void assetType(String multirequestToken){
		setToken("assetType", multirequestToken);
	}

	// features:
	public String getFeatures(){
		return this.features;
	}
	public void setFeatures(String features){
		this.features = features;
	}

	public void features(String multirequestToken){
		setToken("features", multirequestToken);
	}

	// id:
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	public void id(String multirequestToken){
		setToken("id", multirequestToken);
	}

	// parentId:
	public String getParentId(){
		return this.parentId;
	}
	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public void parentId(String multirequestToken){
		setToken("parentId", multirequestToken);
	}

	// partnerId:
	public Integer getPartnerId(){
		return this.partnerId;
	}
	public void setPartnerId(Integer partnerId){
		this.partnerId = partnerId;
	}

	public void partnerId(String multirequestToken){
		setToken("partnerId", multirequestToken);
	}


	public Meta() {
		super();
	}

	public Meta(JsonObject jsonObject) throws APIException {
		super(jsonObject);

		if(jsonObject == null) return;

		// set members values:
		name = GsonParser.parseString(jsonObject.get("name"));
		fieldName = MetaFieldName.get(GsonParser.parseString(jsonObject.get("fieldName")));
		type = MetaType.get(GsonParser.parseString(jsonObject.get("type")));
		assetType = AssetType.get(GsonParser.parseString(jsonObject.get("assetType")));
		features = GsonParser.parseString(jsonObject.get("features"));
		id = GsonParser.parseString(jsonObject.get("id"));
		parentId = GsonParser.parseString(jsonObject.get("parentId"));
		partnerId = GsonParser.parseInt(jsonObject.get("partnerId"));

	}

	public Params toParams() {
		Params kparams = super.toParams();
		kparams.add("objectType", "KalturaMeta");
		kparams.add("name", this.name);
		kparams.add("fieldName", this.fieldName);
		kparams.add("type", this.type);
		kparams.add("assetType", this.assetType);
		kparams.add("features", this.features);
		kparams.add("id", this.id);
		kparams.add("parentId", this.parentId);
		kparams.add("partnerId", this.partnerId);
		return kparams;
	}


    public static final Creator<Meta> CREATOR = new Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel source) {
            return new Meta(source);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.name);
        dest.writeInt(this.fieldName == null ? -1 : this.fieldName.ordinal());
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeInt(this.assetType == null ? -1 : this.assetType.ordinal());
        dest.writeString(this.features);
        dest.writeString(this.id);
        dest.writeString(this.parentId);
        dest.writeValue(this.partnerId);
    }

    public Meta(Parcel in) {
        super(in);
        this.name = in.readString();
        int tmpFieldName = in.readInt();
        this.fieldName = tmpFieldName == -1 ? null : MetaFieldName.values()[tmpFieldName];
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : MetaType.values()[tmpType];
        int tmpAssetType = in.readInt();
        this.assetType = tmpAssetType == -1 ? null : AssetType.values()[tmpAssetType];
        this.features = in.readString();
        this.id = in.readString();
        this.parentId = in.readString();
        this.partnerId = (Integer)in.readValue(Integer.class.getClassLoader());
    }
}


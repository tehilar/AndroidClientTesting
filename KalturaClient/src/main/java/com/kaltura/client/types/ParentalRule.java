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
import com.kaltura.client.enums.ParentalRuleType;
import com.kaltura.client.enums.RuleLevel;
import com.kaltura.client.types.ObjectBase;
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

/**  Parental rule  */
@SuppressWarnings("serial")
@MultiRequestBuilder.Tokenizer(ParentalRule.Tokenizer.class)
public class ParentalRule extends ObjectBase {
	
	public interface Tokenizer extends ObjectBase.Tokenizer {
		String id();
		String name();
		String description();
		String order();
		String mediaTag();
		String epgTag();
		String blockAnonymousAccess();
		String ruleType();
		RequestBuilder.ListTokenizer<StringValue.Tokenizer> mediaTagValues();
		RequestBuilder.ListTokenizer<StringValue.Tokenizer> epgTagValues();
		String isDefault();
		String origin();
	}

	/**  Unique parental rule identifier  */
	private Long id;
	/**  Rule display name  */
	private String name;
	/**  Explanatory description  */
	private String description;
	/**  Rule order within the full list of rules  */
	private Integer order;
	/**  Media asset tag ID to in which to look for corresponding trigger values  */
	private Integer mediaTag;
	/**  EPG asset tag ID to in which to look for corresponding trigger values  */
	private Integer epgTag;
	/**  Content that correspond to this rule is not available for guests  */
	private Boolean blockAnonymousAccess;
	/**  Rule type – Movies, TV series or both  */
	private ParentalRuleType ruleType;
	/**  Media tag values that trigger rule  */
	private List<StringValue> mediaTagValues;
	/**  EPG tag values that trigger rule  */
	private List<StringValue> epgTagValues;
	/**  Is the rule the default rule of the account  */
	private Boolean isDefault;
	/**  Where was this rule defined account, household or user  */
	private RuleLevel origin;

	// id:
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
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

	// description:
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}

	public void description(String multirequestToken){
		setToken("description", multirequestToken);
	}

	// order:
	public Integer getOrder(){
		return this.order;
	}
	public void setOrder(Integer order){
		this.order = order;
	}

	public void order(String multirequestToken){
		setToken("order", multirequestToken);
	}

	// mediaTag:
	public Integer getMediaTag(){
		return this.mediaTag;
	}
	public void setMediaTag(Integer mediaTag){
		this.mediaTag = mediaTag;
	}

	public void mediaTag(String multirequestToken){
		setToken("mediaTag", multirequestToken);
	}

	// epgTag:
	public Integer getEpgTag(){
		return this.epgTag;
	}
	public void setEpgTag(Integer epgTag){
		this.epgTag = epgTag;
	}

	public void epgTag(String multirequestToken){
		setToken("epgTag", multirequestToken);
	}

	// blockAnonymousAccess:
	public Boolean getBlockAnonymousAccess(){
		return this.blockAnonymousAccess;
	}
	public void setBlockAnonymousAccess(Boolean blockAnonymousAccess){
		this.blockAnonymousAccess = blockAnonymousAccess;
	}

	public void blockAnonymousAccess(String multirequestToken){
		setToken("blockAnonymousAccess", multirequestToken);
	}

	// ruleType:
	public ParentalRuleType getRuleType(){
		return this.ruleType;
	}
	public void setRuleType(ParentalRuleType ruleType){
		this.ruleType = ruleType;
	}

	public void ruleType(String multirequestToken){
		setToken("ruleType", multirequestToken);
	}

	// mediaTagValues:
	public List<StringValue> getMediaTagValues(){
		return this.mediaTagValues;
	}
	public void setMediaTagValues(List<StringValue> mediaTagValues){
		this.mediaTagValues = mediaTagValues;
	}

	// epgTagValues:
	public List<StringValue> getEpgTagValues(){
		return this.epgTagValues;
	}
	public void setEpgTagValues(List<StringValue> epgTagValues){
		this.epgTagValues = epgTagValues;
	}

	// isDefault:
	public Boolean getIsDefault(){
		return this.isDefault;
	}
	public void setIsDefault(Boolean isDefault){
		this.isDefault = isDefault;
	}

	public void isDefault(String multirequestToken){
		setToken("isDefault", multirequestToken);
	}

	// origin:
	public RuleLevel getOrigin(){
		return this.origin;
	}
	public void setOrigin(RuleLevel origin){
		this.origin = origin;
	}

	public void origin(String multirequestToken){
		setToken("origin", multirequestToken);
	}


	public ParentalRule() {
		super();
	}

	public ParentalRule(JsonObject jsonObject) throws APIException {
		super(jsonObject);

		if(jsonObject == null) return;

		// set members values:
		id = GsonParser.parseLong(jsonObject.get("id"));
		name = GsonParser.parseString(jsonObject.get("name"));
		description = GsonParser.parseString(jsonObject.get("description"));
		order = GsonParser.parseInt(jsonObject.get("order"));
		mediaTag = GsonParser.parseInt(jsonObject.get("mediaTag"));
		epgTag = GsonParser.parseInt(jsonObject.get("epgTag"));
		blockAnonymousAccess = GsonParser.parseBoolean(jsonObject.get("blockAnonymousAccess"));
		ruleType = ParentalRuleType.get(GsonParser.parseString(jsonObject.get("ruleType")));
		mediaTagValues = GsonParser.parseArray(jsonObject.getAsJsonArray("mediaTagValues"), StringValue.class);
		epgTagValues = GsonParser.parseArray(jsonObject.getAsJsonArray("epgTagValues"), StringValue.class);
		isDefault = GsonParser.parseBoolean(jsonObject.get("isDefault"));
		origin = RuleLevel.get(GsonParser.parseString(jsonObject.get("origin")));

	}

	public Params toParams() {
		Params kparams = super.toParams();
		kparams.add("objectType", "KalturaParentalRule");
		kparams.add("name", this.name);
		kparams.add("description", this.description);
		kparams.add("order", this.order);
		kparams.add("mediaTag", this.mediaTag);
		kparams.add("epgTag", this.epgTag);
		kparams.add("blockAnonymousAccess", this.blockAnonymousAccess);
		kparams.add("ruleType", this.ruleType);
		kparams.add("mediaTagValues", this.mediaTagValues);
		kparams.add("epgTagValues", this.epgTagValues);
		kparams.add("isDefault", this.isDefault);
		kparams.add("origin", this.origin);
		return kparams;
	}


    public static final Creator<ParentalRule> CREATOR = new Creator<ParentalRule>() {
        @Override
        public ParentalRule createFromParcel(Parcel source) {
            return new ParentalRule(source);
        }

        @Override
        public ParentalRule[] newArray(int size) {
            return new ParentalRule[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeValue(this.order);
        dest.writeValue(this.mediaTag);
        dest.writeValue(this.epgTag);
        dest.writeValue(this.blockAnonymousAccess);
        dest.writeInt(this.ruleType == null ? -1 : this.ruleType.ordinal());
        if(this.mediaTagValues != null) {
            dest.writeInt(this.mediaTagValues.size());
            dest.writeList(this.mediaTagValues);
        } else {
            dest.writeInt(-1);
        }
        if(this.epgTagValues != null) {
            dest.writeInt(this.epgTagValues.size());
            dest.writeList(this.epgTagValues);
        } else {
            dest.writeInt(-1);
        }
        dest.writeValue(this.isDefault);
        dest.writeInt(this.origin == null ? -1 : this.origin.ordinal());
    }

    public ParentalRule(Parcel in) {
        super(in);
        this.id = (Long)in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.description = in.readString();
        this.order = (Integer)in.readValue(Integer.class.getClassLoader());
        this.mediaTag = (Integer)in.readValue(Integer.class.getClassLoader());
        this.epgTag = (Integer)in.readValue(Integer.class.getClassLoader());
        this.blockAnonymousAccess = (Boolean)in.readValue(Boolean.class.getClassLoader());
        int tmpRuleType = in.readInt();
        this.ruleType = tmpRuleType == -1 ? null : ParentalRuleType.values()[tmpRuleType];
        int mediaTagValuesSize = in.readInt();
        if( mediaTagValuesSize > -1) {
            this.mediaTagValues = new ArrayList<>();
            in.readList(this.mediaTagValues, StringValue.class.getClassLoader());
        }
        int epgTagValuesSize = in.readInt();
        if( epgTagValuesSize > -1) {
            this.epgTagValues = new ArrayList<>();
            in.readList(this.epgTagValues, StringValue.class.getClassLoader());
        }
        this.isDefault = (Boolean)in.readValue(Boolean.class.getClassLoader());
        int tmpOrigin = in.readInt();
        this.origin = tmpOrigin == -1 ? null : RuleLevel.values()[tmpOrigin];
    }
}


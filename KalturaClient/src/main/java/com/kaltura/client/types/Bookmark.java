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
import com.kaltura.client.enums.PositionOwner;
import com.kaltura.client.types.BookmarkPlayerData;
import com.kaltura.client.utils.GsonParser;
import com.kaltura.client.utils.request.MultiRequestBuilder;

/**
 * This class was generated using exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
@MultiRequestBuilder.Tokenizer(Bookmark.Tokenizer.class)
public class Bookmark extends SlimAsset {
	
	public interface Tokenizer extends SlimAsset.Tokenizer {
		String userId();
		String position();
		String positionOwner();
		String finishedWatching();
		BookmarkPlayerData.Tokenizer playerData();
	}

	/**  User identifier  */
	private String userId;
	/**  The position of the user in the specific asset (in seconds)  */
	private Integer position;
	/**  Indicates who is the owner of this position  */
	private PositionOwner positionOwner;
	/**  Specifies whether the user&amp;#39;s current position exceeded 95% of the
	  duration  */
	private Boolean finishedWatching;
	/**  Insert only player data  */
	private BookmarkPlayerData playerData;

	// userId:
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public void userId(String multirequestToken){
		setToken("userId", multirequestToken);
	}

	// position:
	public Integer getPosition(){
		return this.position;
	}
	public void setPosition(Integer position){
		this.position = position;
	}

	public void position(String multirequestToken){
		setToken("position", multirequestToken);
	}

	// positionOwner:
	public PositionOwner getPositionOwner(){
		return this.positionOwner;
	}
	public void setPositionOwner(PositionOwner positionOwner){
		this.positionOwner = positionOwner;
	}

	public void positionOwner(String multirequestToken){
		setToken("positionOwner", multirequestToken);
	}

	// finishedWatching:
	public Boolean getFinishedWatching(){
		return this.finishedWatching;
	}
	public void setFinishedWatching(Boolean finishedWatching){
		this.finishedWatching = finishedWatching;
	}

	public void finishedWatching(String multirequestToken){
		setToken("finishedWatching", multirequestToken);
	}

	// playerData:
	public BookmarkPlayerData getPlayerData(){
		return this.playerData;
	}
	public void setPlayerData(BookmarkPlayerData playerData){
		this.playerData = playerData;
	}


	public Bookmark() {
		super();
	}

	public Bookmark(JsonObject jsonObject) throws APIException {
		super(jsonObject);

		if(jsonObject == null) return;

		// set members values:
		userId = GsonParser.parseString(jsonObject.get("userId"));
		position = GsonParser.parseInt(jsonObject.get("position"));
		positionOwner = PositionOwner.get(GsonParser.parseString(jsonObject.get("positionOwner")));
		finishedWatching = GsonParser.parseBoolean(jsonObject.get("finishedWatching"));
		playerData = GsonParser.parseObject(jsonObject.getAsJsonObject("playerData"), BookmarkPlayerData.class);

	}

	public Params toParams() {
		Params kparams = super.toParams();
		kparams.add("objectType", "KalturaBookmark");
		kparams.add("position", this.position);
		kparams.add("playerData", this.playerData);
		return kparams;
	}


    public static final Creator<Bookmark> CREATOR = new Creator<Bookmark>() {
        @Override
        public Bookmark createFromParcel(Parcel source) {
            return new Bookmark(source);
        }

        @Override
        public Bookmark[] newArray(int size) {
            return new Bookmark[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.userId);
        dest.writeValue(this.position);
        dest.writeInt(this.positionOwner == null ? -1 : this.positionOwner.ordinal());
        dest.writeValue(this.finishedWatching);
        dest.writeParcelable(this.playerData, flags);
    }

    public Bookmark(Parcel in) {
        super(in);
        this.userId = in.readString();
        this.position = (Integer)in.readValue(Integer.class.getClassLoader());
        int tmpPositionOwner = in.readInt();
        this.positionOwner = tmpPositionOwner == -1 ? null : PositionOwner.values()[tmpPositionOwner];
        this.finishedWatching = (Boolean)in.readValue(Boolean.class.getClassLoader());
        this.playerData = in.readParcelable(BookmarkPlayerData.class.getClassLoader());
    }
}


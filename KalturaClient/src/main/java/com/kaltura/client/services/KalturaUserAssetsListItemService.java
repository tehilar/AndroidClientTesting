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
package com.kaltura.client.services;

import com.kaltura.client.KalturaClient;
import com.kaltura.client.KalturaServiceBase;
import com.kaltura.client.types.*;
import org.w3c.dom.Element;
import com.kaltura.client.utils.ParseUtils;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.enums.*;

/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class KalturaUserAssetsListItemService extends KalturaServiceBase {
    public KalturaUserAssetsListItemService(KalturaClient client) {
        this.kalturaClient = client;
    }

	/**  Adds a new item to user’s private asset list  */
    public KalturaUserAssetsListItem add(KalturaUserAssetsListItem userAssetsListItem) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("userAssetsListItem", userAssetsListItem);
        this.kalturaClient.queueServiceCall("userassetslistitem", "add", kparams, KalturaUserAssetsListItem.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaUserAssetsListItem.class, resultXmlElement);
    }

	/**  Deletes an item from user’s private asset list  */
    public boolean delete(String assetId, KalturaUserAssetsListType listType) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("assetId", assetId);
        kparams.add("listType", listType);
        this.kalturaClient.queueServiceCall("userassetslistitem", "delete", kparams);
        if (this.kalturaClient.isMultiRequest())
            return false;
        Element resultXmlElement = this.kalturaClient.doQueue();
        String resultText = resultXmlElement.getTextContent();
        return ParseUtils.parseBool(resultText);
    }

	/**  Get an item from user’s private asset list  */
    public KalturaUserAssetsListItem get(String assetId, KalturaUserAssetsListType listType, KalturaUserAssetsListItemType itemType) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("assetId", assetId);
        kparams.add("listType", listType);
        kparams.add("itemType", itemType);
        this.kalturaClient.queueServiceCall("userassetslistitem", "get", kparams, KalturaUserAssetsListItem.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaUserAssetsListItem.class, resultXmlElement);
    }
}

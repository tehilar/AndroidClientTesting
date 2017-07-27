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
import com.kaltura.client.enums.*;
import org.w3c.dom.Element;
import com.kaltura.client.utils.ParseUtils;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;

/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class KalturaMessageTemplateService extends KalturaServiceBase {
    public KalturaMessageTemplateService(KalturaClient client) {
        this.kalturaClient = client;
    }

	/**  Retrieve a message template used in push notifications and inbox  */
    public KalturaMessageTemplate get(KalturaMessageTemplateType messageType) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("messageType", messageType);
        this.kalturaClient.queueServiceCall("messagetemplate", "get", kparams, KalturaMessageTemplate.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaMessageTemplate.class, resultXmlElement);
    }

	/**  Set the account’s push notifications and inbox messages templates  */
    public KalturaMessageTemplate update(KalturaMessageTemplateType messageType, KalturaMessageTemplate template) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("messageType", messageType);
        kparams.add("template", template);
        this.kalturaClient.queueServiceCall("messagetemplate", "update", kparams, KalturaMessageTemplate.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaMessageTemplate.class, resultXmlElement);
    }
}
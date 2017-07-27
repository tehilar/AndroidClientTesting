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

import org.w3c.dom.Element;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaObjectBase;
import com.kaltura.client.enums.KalturaAppTokenHashType;
import com.kaltura.client.enums.KalturaSessionType;
import com.kaltura.client.enums.KalturaAppTokenStatus;
import com.kaltura.client.utils.ParseUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  Application token  */
@SuppressWarnings("serial")
public class KalturaAppToken extends KalturaObjectBase {
	/**  The id of the application token  */
    public String id;
	/**  Expiry time of current token (unix timestamp in seconds)  */
    public int expiry = Integer.MIN_VALUE;
	/**  Partner identifier  */
    public int partnerId = Integer.MIN_VALUE;
	/**  Expiry duration of KS (Kaltura Session) that created using the current token (in
	  seconds)  */
    public int sessionDuration = Integer.MIN_VALUE;
	/**  The hash type of the token  */
    public KalturaAppTokenHashType hashType;
	/**  Comma separated privileges to be applied on KS (Kaltura Session) that created
	  using the current token  */
    public String sessionPrivileges;
	/**  Type of KS (Kaltura Session) that created using the current token  */
    public KalturaSessionType sessionType;
	/**  Application token status  */
    public KalturaAppTokenStatus status;
	/**  The application token  */
    public String token;
	/**  User id of KS (Kaltura Session) that created using the current token  */
    public String sessionUserId;

    public KalturaAppToken() {
    }

    public KalturaAppToken(Element node) throws KalturaApiException {
        super(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node aNode = childNodes.item(i);
            String nodeName = aNode.getNodeName();
            String txt = aNode.getTextContent();
            if (nodeName.equals("id")) {
                this.id = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("expiry")) {
                this.expiry = ParseUtils.parseInt(txt);
                continue;
            } else if (nodeName.equals("partnerId")) {
                this.partnerId = ParseUtils.parseInt(txt);
                continue;
            } else if (nodeName.equals("sessionDuration")) {
                this.sessionDuration = ParseUtils.parseInt(txt);
                continue;
            } else if (nodeName.equals("hashType")) {
                this.hashType = KalturaAppTokenHashType.get(ParseUtils.parseString(txt));
                continue;
            } else if (nodeName.equals("sessionPrivileges")) {
                this.sessionPrivileges = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("sessionType")) {
                this.sessionType = KalturaSessionType.get(ParseUtils.parseInt(txt));
                continue;
            } else if (nodeName.equals("status")) {
                this.status = KalturaAppTokenStatus.get(ParseUtils.parseInt(txt));
                continue;
            } else if (nodeName.equals("token")) {
                this.token = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("sessionUserId")) {
                this.sessionUserId = ParseUtils.parseString(txt);
                continue;
            } 
        }
    }

    public KalturaParams toParams() throws KalturaApiException {
        KalturaParams kparams = super.toParams();
        kparams.add("objectType", "KalturaAppToken");
        kparams.add("expiry", this.expiry);
        kparams.add("sessionDuration", this.sessionDuration);
        kparams.add("hashType", this.hashType);
        kparams.add("sessionPrivileges", this.sessionPrivileges);
        kparams.add("sessionType", this.sessionType);
        kparams.add("sessionUserId", this.sessionUserId);
        return kparams;
    }

}


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
import com.kaltura.client.enums.KalturaRuleType;
import com.kaltura.client.utils.ParseUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

/**  User asset rule - representing different type of rules on an asset(Parental,
  Geo, User Type, Device)  */
@SuppressWarnings("serial")
public class KalturaUserAssetRule extends KalturaObjectBase {
	/**  Unique rule identifier  */
    public long id = Long.MIN_VALUE;
	/**  Rule type - possible values: Rule type – Parental, Geo, UserType, Device  */
    public KalturaRuleType ruleType;
	/**  Rule display name  */
    public String name;
	/**  Additional description for the specific rule  */
    public String description;

    public KalturaUserAssetRule() {
    }

    public KalturaUserAssetRule(Element node) throws KalturaApiException {
        super(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node aNode = childNodes.item(i);
            String nodeName = aNode.getNodeName();
            String txt = aNode.getTextContent();
            if (nodeName.equals("id")) {
                this.id = ParseUtils.parseBigint(txt);
                continue;
            } else if (nodeName.equals("ruleType")) {
                this.ruleType = KalturaRuleType.get(ParseUtils.parseString(txt));
                continue;
            } else if (nodeName.equals("name")) {
                this.name = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("description")) {
                this.description = ParseUtils.parseString(txt);
                continue;
            } 
        }
    }

    public KalturaParams toParams() throws KalturaApiException {
        KalturaParams kparams = super.toParams();
        kparams.add("objectType", "KalturaUserAssetRule");
        kparams.add("ruleType", this.ruleType);
        kparams.add("name", this.name);
        kparams.add("description", this.description);
        return kparams;
    }

}


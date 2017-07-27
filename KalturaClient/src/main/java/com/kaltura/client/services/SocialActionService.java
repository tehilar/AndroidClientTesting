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

import com.kaltura.client.Params;
import com.kaltura.client.types.FilterPager;
import com.kaltura.client.types.ListResponse;
import com.kaltura.client.types.NetworkActionStatus;
import com.kaltura.client.types.SocialAction;
import com.kaltura.client.types.SocialActionFilter;
import com.kaltura.client.types.UserSocialActionResponse;
import com.kaltura.client.utils.request.ArrayRequestBuilder;
import com.kaltura.client.utils.request.ListResponseRequestBuilder;
import com.kaltura.client.utils.request.RequestBuilder;
import java.util.List;

/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

public class SocialActionService {

	/**  Insert new user social action  */
    public static RequestBuilder<UserSocialActionResponse> add(SocialAction socialAction)  {
        Params kparams = new Params();
        kparams.add("socialAction", socialAction);

        return new RequestBuilder<UserSocialActionResponse>(UserSocialActionResponse.class, "socialaction", "add", kparams);
    }

	/**  delete user social action  */
    public static RequestBuilder<List<NetworkActionStatus>> delete(String id)  {
        Params kparams = new Params();
        kparams.add("id", id);

        return new ArrayRequestBuilder<NetworkActionStatus>(NetworkActionStatus.class, "socialaction", "delete", kparams);
    }

    public static RequestBuilder<ListResponse<SocialAction>> list(SocialActionFilter filter)  {
        return list(filter, null);
    }

	/**  Get list of user social actions  */
    public static RequestBuilder<ListResponse<SocialAction>> list(SocialActionFilter filter, FilterPager pager)  {
        Params kparams = new Params();
        kparams.add("filter", filter);
        kparams.add("pager", pager);

        return new ListResponseRequestBuilder<SocialAction>(SocialAction.class, "socialaction", "list", kparams);
    }
}
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
// Copyright (C) 2006-2011  Kaltura Inc.
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
package com.kaltura.client;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

abstract public class Logger implements ILogger
{
	@Retention(RetentionPolicy.SOURCE)
	@IntDef({})
	@interface LogLevel{
		int All = 0;
		int Verbose = 1;
		int Debug = 2;
		int Info = 3;
		int Warning = 4;
		int Error = 5;
		int Assert = 6;
		int Fatal = 7;
	}

	protected @LogLevel int logLevel = LogLevel.All;

	// Creation & retrieval methods:
	public static Logger getLogger(String name)
	{
		return LoggerAndroid.getLogger(name);
	}

	public void logLevel(int logLevel) {
		this.logLevel = logLevel;
	}

	public static Logger getLogger(Class<?> clazz)
	{
		return getLogger(clazz.getName());
	}
	
	public boolean isEnabled()
	{
		return true;
	}

	// printing methods:
	abstract public void trace(Object message);
	abstract public void debug(Object message);
	abstract public void info(Object message);
	abstract public void warn(Object message);
	abstract public void error(Object message);
	abstract public void fatal(Object message);

	abstract public void trace(Object message, Throwable t);
	abstract public void debug(Object message, Throwable t);
	abstract public void info(Object message, Throwable t);
	abstract public void warn(Object message, Throwable t);
	abstract public void error(Object message, Throwable t);
	abstract public void fatal(Object message, Throwable t);
}

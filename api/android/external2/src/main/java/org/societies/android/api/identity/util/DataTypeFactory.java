/**
 * Copyright (c) 2011, SOCIETIES Consortium (WATERFORD INSTITUTE OF TECHNOLOGY (TSSG), HERIOT-WATT UNIVERSITY (HWU), SOLUTA.NET 
 * (SN), GERMAN AEROSPACE CENTRE (Deutsches Zentrum fuer Luft- und Raumfahrt e.V.) (DLR), Zavod za varnostne tehnologije
 * informacijske družbe in elektronsko poslovanje (SETCCE), INSTITUTE OF COMMUNICATION AND COMPUTER SYSTEMS (ICCS), LAKE
 * COMMUNICATIONS (LAKE), INTEL PERFORMANCE LEARNING SOLUTIONS LTD (INTEL), PORTUGAL TELECOM INOVAÇÃO, SA (PTIN), IBM Corp., 
 * INSTITUT TELECOM (ITSUD), AMITEC DIACHYTI EFYIA PLIROFORIKI KAI EPIKINONIES ETERIA PERIORISMENIS EFTHINIS (AMITEC), TELECOM 
 * ITALIA S.p.a.(TI),  TRIALOG (TRIALOG), Stiftelsen SINTEF (SINTEF), NEC EUROPE LTD (NEC))
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.societies.android.api.identity.util;

import org.societies.android.api.identity.SimpleDataIdentifier;
import org.societies.api.schema.identity.DataIdentifier;
import org.societies.api.schema.identity.DataIdentifierScheme;

/**
 * Utility method that helps manipulating DataIdentifier objects
 *
 * @author Olivier Maridat (Trialog)
 *
 */
public class DataTypeFactory {
	/**
	 * Create the relevant data type using a correct URI
	 *
	 * @param dataIdUri URI format sheme://ownerId/type
	 * @return the relevant DataIdentifier type instance
	 * @throws MalformedCtxIdentifierException 
	 */
	public static DataIdentifier fromUri(String dataIdUri) {
		String[] uri = dataIdUri.split("://");
		DataIdentifierScheme scheme = null;
		try {
			scheme = DataIdentifierScheme.fromValue(uri[0]);
		}
		catch(IllegalArgumentException e) {
			scheme = DataIdentifierScheme.CONTEXT;
		}

		DataIdentifier dataId = new SimpleDataIdentifier();
		dataId.setScheme(scheme);
		String path = uri[1];
		int pos = 0, end = 0, endType = 0;
		if ((end = path.indexOf('/', pos)) >= 0) {
			dataId.setOwnerId(path.substring(pos, end));
		}
		endType = path.length();
		if (path.endsWith("/") && endType > 1) {
			endType--;
		}
		dataId.setType(path.substring(end+1, endType));
		dataId.setUri(dataIdUri);
		return dataId;
	}
	
	/**
	 * Retrieve the scheme of a DataIdentifier for sure: from its URI or its type field
	 * @param dataId
	 * @return Data scheme
	 */
	public static DataIdentifierScheme getScheme(DataIdentifier dataId) {
		if (null != dataId.getScheme()) {
			return dataId.getScheme();
		}
		return fromUri(dataId.getUri()).getScheme();
	}
	
	/**
	 * Retrieve the type of a DataIdentifier for sure: from its URI or its type field
	 * @param dataId
	 * @return Data type
	 */
	public static String getType(DataIdentifier dataId) {
		if (null != dataId.getType()) {
			return dataId.getType();
		}
		return fromUri(dataId.getUri()).getType();
	}
}

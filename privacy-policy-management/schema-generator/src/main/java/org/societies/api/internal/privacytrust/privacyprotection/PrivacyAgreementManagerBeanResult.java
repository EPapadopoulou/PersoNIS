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
package org.societies.api.internal.privacytrust.privacyprotection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.societies.api.internal.privacytrust.privacyprotection.PrivacyPolicyManagerBean.methodType;
import org.societies.api.internal.schema.privacytrust.privacyprotection.model.privacypolicy.AgreementEnvelope;

/**
 * @author Olivier Maridat (Trialog)
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PrivacyAgreementManagerBeanResult {
	@XmlElement(required = true)
	private methodType  method;
	
	@XmlElement(required = true)
	private boolean ack;
	
	private String ackMessage;
	
	private AgreementEnvelope privacyAgreement;
	
	
	
	/**
	 * @return the ack
	 */
	public boolean isAck() {
		return ack;
	}
	/**
	 * @param ack the ack to set
	 */
	public void setAck(boolean ack) {
		this.ack = ack;
	}
	/**
	 * @return the ackMessage
	 */
	public String getAckMessage() {
		return ackMessage;
	}
	/**
	 * @param ackMessage the ackMessage to set
	 */
	public void setAckMessage(String ackMessage) {
		this.ackMessage = ackMessage;
	}
	/**
	 * @return the method
	 */
	public methodType getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(methodType method) {
		this.method = method;
	}
	/**
	 * @return the privacyAgreement
	 */
	public AgreementEnvelope getPrivacyAgreement() {
		return privacyAgreement;
	}
	/**
	 * @param privacyAgreement the privacyAgreement to set
	 */
	public void setPrivacyAgreement(AgreementEnvelope privacyAgreement) {
		this.privacyAgreement = privacyAgreement;
	}
}

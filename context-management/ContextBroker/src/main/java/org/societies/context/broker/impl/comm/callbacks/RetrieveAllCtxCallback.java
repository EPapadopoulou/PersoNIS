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
package org.societies.context.broker.impl.comm.callbacks;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.societies.api.context.CtxException;
import org.societies.api.context.model.CtxAssociation;
import org.societies.api.context.model.CtxAttribute;
import org.societies.api.context.model.CtxEntity;
import org.societies.api.context.model.CtxEntityIdentifier;
import org.societies.api.context.model.CtxIdentifier;
import org.societies.api.context.model.CtxModelObject;

/**
 * 
 * Describe your class here...
 *
 * @author <a href="mailto:nicolas.liampotis@cn.ntua.gr">Nicolas Liampotis</a> (ICCS)
 * @since 2.0
 */
public class RetrieveAllCtxCallback extends CtxCallback {

	/** The logging facility. */
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveAllCtxCallback.class);
	
	private final CountDownLatch doneSignal;
	
	private List<CtxModelObject> result;
	
	public RetrieveAllCtxCallback(CountDownLatch doneSignal) {
		
		this.doneSignal = doneSignal;
	}
	
	public List<CtxModelObject> getResult() {
		
		return this.result;
	}
	
	/*
	 * @see org.societies.context.broker.impl.comm.ICtxCallback#onException(org.societies.api.context.CtxException)
	 */
	@Override
	public void onException(CtxException exception) {
		
		LOG.debug("onException: exception={}", exception);
		super.exception = exception;
		this.doneSignal.countDown();
	}

	@Override
	public void onCreatedEntity(CtxEntity retObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreatedAttribute(CtxAttribute retObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLookupCallback(List<CtxIdentifier> ctxIdsList) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see org.societies.context.broker.impl.comm.ICtxCallback#onRetrieveCtx(org.societies.api.context.model.CtxModelObject)
	 */
	@Override
	public void onRetrieveCtx(CtxModelObject ctxObj) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * @see org.societies.context.broker.impl.comm.ICtxCallback#onRetrieveCtx(org.societies.api.context.model.CtxModelObject)
	 */
	@Override
	public void onRetrievedAll(List<CtxModelObject> ctxModelObjectList) {
		
		LOG.debug("onRetrievedAll: ctxModelObjectList={}", ctxModelObjectList);
		this.result = ctxModelObjectList;
		this.doneSignal.countDown();
	}
	
	@Override
	public void onUpdateCtx(CtxModelObject ctxObj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRetrievedEntityId(CtxEntityIdentifier ctxId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreatedAssociation(CtxAssociation retObject) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * @see org.societies.context.broker.impl.comm.ICtxCallback#onRemovedModelObject(org.societies.api.context.model.CtxModelObject)
	 */
	@Override
	public void onRemovedModelObject(CtxModelObject ctxObj) {
		
		// TODO Auto-generated method stub
	}

	@Override
	public void onRetrieveFutureCtx(List<CtxAttribute> ctxAttrList) {
		// TODO Auto-generated method stub
		
	}
}
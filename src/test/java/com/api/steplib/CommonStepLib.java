package com.api.steplib;

import com.api.steps.BaseStep;

import junit.framework.Assert;

public class CommonStepLib extends BaseStep{

	public void verifyStatusCode(String strStatusCode)
	{				
		Assert.assertEquals("Statuscode not matching", response.getStatusCode(),(Integer.parseInt(strStatusCode)));		
	}
}

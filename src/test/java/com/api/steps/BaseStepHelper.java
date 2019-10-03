package com.api.steps;

import com.api.model.GenericVO;
import com.api.model.PetVO;

public class BaseStepHelper {

	public static GenericVO createObject(String strObjtype, String ...params)
	{
		GenericVO obj = null;
		switch(strObjtype) {
		case "pet":
			obj = new PetVO(params[0], params[1]);
		}
		return obj;
		
	}
}

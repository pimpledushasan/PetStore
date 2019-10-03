package com.api.payload;

import com.api.model.GenericVO;
import com.api.model.PetVO;

public class PetPayload implements Payload{

	
	public PetPayload()
	{
		
	}

	@Override
	public String getPayLoad(GenericVO obj) {
		
		String jsonString = "";
		if(obj instanceof PetVO) {
			PetVO petvo = (PetVO) obj;
			jsonString = createPetAddpayload(petvo);
		}
		return jsonString;
	}
	
	
	private String createPetAddpayload(PetVO obj) {
		
		//create your Payload here using PetVO
		return null;
		
	}
}

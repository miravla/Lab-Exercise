package server;

import ItemProduct.ItemProduct;

public class Validation  {
	
	
	public String validateItemName(ItemProduct itemProduct)
	{
		
		String result = "Valid Name. ", name = itemProduct.getName();
		
		for(int i=0; i<name.length();i++)
		{
		    
			char nameChar = name.charAt(i);
		    
			// To check if the character is not alphabet or space
			if (!(Character.isLetter(nameChar) || nameChar == ' ') )
			{
				
				result="Invalid Name. ";
				
		    }
		
		}
		return result;	
	

	}



}
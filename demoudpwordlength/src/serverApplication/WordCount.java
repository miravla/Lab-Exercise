package serverApplication;

public class WordCount {

	// Count the number of words in text
	public String getWordCount(String text)
	{
		
		int noOfWord=1;
		for(int i = 0 ; i<text.length(); i++)
		{
			char word=text.charAt(i);
			if(Character.isWhitespace(word))
			{
				++noOfWord;
				
			}
			
		}
		
		String str1 = Integer.toString(noOfWord);
		return str1;
		
	}



}
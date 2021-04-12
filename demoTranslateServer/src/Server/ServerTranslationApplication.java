package Server;


public class ServerTranslationApplication{
	public String chooseLanguage(int language, int translatedWord)
	{
		String result="";
		
		switch (language)
		{
		
			case 0 :
				result=BahasaMalaysia(translatedWord);
				break;
			case 1 :
				result=Korean(translatedWord);
				break;
			case 2 :
				result=Arabic(translatedWord);
				break;
			default:
				System.out.print("Something Wrongs!");
										
		}
		return result;
		
	}
	
	private String BahasaMalaysia (int translatedWord)
	{
		String bahasaMalaysia = "";
		switch (translatedWord)
		{
		
			case 0 :
				bahasaMalaysia= "Selamat pagi";
				break;
			case 1 :
				bahasaMalaysia = "Selamat malam";
				break;
			case 2 :
				bahasaMalaysia = "Apa khabar?";
				break;
			case 3 :
				bahasaMalaysia = "Terima kasih";
				break;
			case 4 :
				bahasaMalaysia = "Selamat tinggal";
				break;
			case 5 :
				bahasaMalaysia ="Ada apa?";
				break;
			default:
				System.out.print("Something Wrongs!");
										
		}
		
		return bahasaMalaysia;
	}
	
	private String Korean (int translatedWord)
	{
		
		String korean = "";
		switch (translatedWord)
		{
		
			case 0 :
				korean= "좋은 아침";
				break;
			case 1 :
				korean = "안녕히 주무세요";
				break;
			case 2 :
				korean = "어떻게 지내세요?";
				break;
			case 3 :
				korean = "감사합니다";
				break;
			case 4 :
				korean = "안녕";
				break;
			case 5 :
				korean = "뭐야?";
				break;
			default:
				System.out.print("Something Wrongs!");
		}
		return korean;
		
	}
	
	
	private String Arabic (int translatedWord)
	{
		
		String arabic = "";
		switch (translatedWord)
		{
		
			case 0 :
				arabic= " الخير صباح ";
				break;
			case 1 :
				arabic = "مساؤك طاب";
				break;
			case 2 :
				arabic = "حالك؟ كيف";
				break;
			case 3 :
				arabic = "لك شكر";
				break;
			case 4 :
				arabic = "السالمة مع";
				break;
			case 5 :
				arabic = "أخبارك؟ ما";
				break;
			default:
				System.out.print("Something Wrongs!");
										
		}
		return arabic;
		
	}
	
	
}
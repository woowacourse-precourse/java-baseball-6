package baseball;

public class EncouterException {
	
	private final ProcessMembers proc=new ProcessMembers();
	
	private final int invalid_digit=0;
	private final int smallest_3digits=100;
	private final int greatest_3digits=999;
	
	public EncouterException(String input) {
    		   	
	   	int inputNum=Integer.parseInt(validInput(input));
	   	int [] parsedData=proc.parsingData(inputNum);
	    
	   	exceptionmeter(inputNum, parsedData);
	}
	
	public void exceptionmeter(int inputNum,int [] parsedData) {
		
		exactNumberOfDigits(inputNum);
		outOfZero(parsedData[0], parsedData[1], parsedData[2]);
		withoutDuplicateDigits(parsedData[0], parsedData[1], parsedData[2]);
	}
	
	public void exactNumberOfDigits(int inputNum) {
		
		if(inputNum<smallest_3digits||inputNum>greatest_3digits) {
	    	//this.flag=true;
	    	throw new IllegalArgumentException("3자리 숫자만 입력해주세요");
		}
	}
	
	public void outOfZero(int first_digit,int second_digit,int third_digit) {
		
		if(first_digit==invalid_digit||second_digit==invalid_digit||third_digit==invalid_digit) {
			//this.flag=true;
			throw new IllegalArgumentException("각 자리 수는 1~9만 가능합니다");
		}
	}
	
	public void withoutDuplicateDigits(int first_digit,int second_digit,int third_digit) {
		
		if(first_digit==second_digit||first_digit==third_digit||second_digit==third_digit) {
			//this.flag=true;
			throw new IllegalArgumentException("모든 자리 수는 달라야 합니다");
		}
	}
	
	public String validInput(String input) {
		
		 if(!isNumber(input)) {
		   	//this.flag=true;
		   	throw new IllegalArgumentException("숫자만 입력해주세요");
		 }
		 return input;
	}
	
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
			
		} catch(NumberFormatException e) {
			return false;
		}
	}
}

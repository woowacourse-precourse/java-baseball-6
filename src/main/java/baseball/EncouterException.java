package baseball;

public class EncouterException {

	private boolean flag;	
	private String result;
	
	public EncouterException(String input) {
    	
    	//try {
	    	if(!isNumber(input)) {
	    		this.flag=true;
	    		throw new IllegalArgumentException("숫자만 입력해주세요");
	    	}
	    	
	    	int inputNum=Integer.parseInt(input);
    		
    		int first_digit=inputNum/100;
        	int second_digit=(inputNum%100)/10;
        	int third_digit=inputNum%10;
	    	
	    	if(inputNum<100||inputNum>999) {
	    		this.flag=true;
	    		throw new IllegalArgumentException("3자리 숫자만 입력해주세요");
			}
			else if(first_digit==0||second_digit==0||third_digit==0) {
				this.flag=true;
				throw new IllegalArgumentException("각 자리 수는 1~9만 가능합니다");
			}
			else if(first_digit==second_digit||first_digit==third_digit||second_digit==third_digit) {
				this.flag=true;
				throw new IllegalArgumentException("모든 자리 수는 달라야 합니다");
			}
    	//} catch(IllegalArgumentException e) {
    		//System.out.println(e.toString());
    		//e.printStackTrace();
    		//this.flag=true;
    	//}
	}
	
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
			
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	public String getResult() {
		return this.result;
	}
}

package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class IllegalArgumentException extends Exception {

	public IllegalArgumentException(String msg) {super(msg);}
	public String getMessage() {return super.getMessage();}
}

public class Application {
	
	public static List<Integer> getRandomNumbers() {
		
		List<Integer> computer=new ArrayList<>();
    	while (computer.size()<3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {computer.add(randomNumber);}
    	}
		return computer;
	}
	
	public static List<Integer> gatherDivs(int first,int second,int third) {
		
		List<Integer> list=new ArrayList<Integer>();
		
    	list.add(first);
    	list.add(second);
    	list.add(third);
		
    	return list;
	}
	
	public static String inspection(List<Integer> input,List<Integer> computer) {
		
		String result="";
		int strike=0,ball=0;
		
		for(int i=0;i<computer.size();i++) {
			if(computer.get(i)==input.get(i)) {strike++;}
			if(computer.contains(input.get(i))) {ball++;}
		}
		ball=ball-strike;
		
		result=((ball!=0?ball+"볼 ":"")+(strike!=0?strike+"스트라이크":"")).equals("")?"낫싱":(ball!=0?ball+"볼 ":"")+(strike!=0?strike+"스트라이크":"");
		
		return result;
	}
	
    public static void main(String[] args) {
    	
    	List<Integer> computer=getRandomNumbers();
    	String result="",more="1";
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while(!result.equals("3스트라이크")&&more.equals("1")) {
    		System.out.printf("숫자를 입력해주세요 : ");
	    	int input=0,first_digit=0,second_digit=0,third_digit=0;
	    	
	    	try {
	    		input=Integer.parseInt(Console.readLine());
	    		
	    		first_digit=input/100;
		    	second_digit=(input%100)/10;
		    	third_digit=input%10;
		    	
	    		if(input<100||input>999) {throw new IllegalArgumentException("3자리 숫자만 입력해주세요");}
	    		else if(first_digit==0||second_digit==0||third_digit==0) {throw new IllegalArgumentException("각 자리 수는 1~9만 가능합니다");}
	    		else if(first_digit==second_digit||first_digit==third_digit||second_digit==third_digit) {throw new IllegalArgumentException("모든 자리 수는 달라야 합니다");}
	    		//입력값이 숫자가 아닐경우 예외처리
	    		
	    	} catch(IllegalArgumentException e) {
	    		System.out.println(e.getMessage());
	    		return;
	    	} catch(NumberFormatException e) {
	    		System.out.println(e.getMessage());
	    		return;
	    	}
	    	List<Integer> list=gatherDivs(first_digit, second_digit, third_digit);
	    	
	    	result=inspection(computer, list);
	    	
	    	System.out.println(result);
	    	
	    	if(result.equals("3스트라이크")) {
	    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	    		try {
	    			more=Console.readLine();
	    			
	    			if(!more.equals("1")&&!more.equals("2")) {throw new IllegalArgumentException("1,2중 하나만 입력해주세요");}
	    		
	    		} catch(IllegalArgumentException e) {
	    			System.out.println(e.getMessage());
	    			return;
	    		}
	    		
	    		if(more.equals("1")) {
	    			computer=getRandomNumbers();
	    			result="";
	    		}
	    		else {
	    			System.out.println("게임종료");
	    			return;
	    		}	
	    	}
    	}
    }
}

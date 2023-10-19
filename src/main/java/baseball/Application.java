package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	
	public static List<Integer> getRandomNumbers() {
		
		List<Integer> computer=new ArrayList<>();
    	while (computer.size()<3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
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
	
	public static String synagogue_inspection(List<Integer> input,List<Integer> computer) {
		
		String result="";
		int strike=0;
		int ball=0;
		
		for(int i=0;i<computer.size();i++) {
			if(computer.get(i)==input.get(i))
				strike++;
			if(computer.contains(input.get(i)))
				ball++;
		}
		ball=ball-strike;
		
		if(strike==0&&ball==0)
			result="낫싱";
		else if(strike==0&&ball!=0)
			result=ball+"볼";
		else if(strike!=0&&ball==0)
			result=strike+"스트라이크";
		else
			result=ball+"볼 "+strike+"스트라이크";
		
		return result;
	}
	
    public static void main(String[] args) {
    	
    	List<Integer> computer=getRandomNumbers();
    	String result="";
    	String more="1";
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while(!result.equals("3스트라이크")&&more.equals("1")) {
	    	int input=Integer.parseInt(Console.readLine());
	    	int first_digit=input/100;
	    	int second_digit=(input%100)/10;
	    	int third_digit=input%10;
	    	
	    	if(input<100||input>999) {
	    		System.out.println("3자리 숫자만 입력해주세요");
	    		continue;
	    	}
	    	else if(first_digit==0||second_digit==0||third_digit==0) {
				System.out.println("각 자리 수는 1~9만 가능합니다");
				continue;
			}
	    	else if(first_digit==second_digit||first_digit==third_digit||second_digit==third_digit) {
	    		System.out.println("모든 자리 수는 달라야 합니다");
	    		continue;
	    	}
	    	
	    	List<Integer> list=gatherDivs(first_digit, second_digit, third_digit);
	    	
	    	result=synagogue_inspection(computer, list);
	    	
	    	System.out.println(result);
	    	
	    	if(result.equals("3스트라이크")) {
	    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	    		more=Console.readLine();
	    		while(!more.equals("1")&&!more.equals("2")) {
	    			System.out.println("1,2중 하나만 입력해주세요");
	    			more=Console.readLine();
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

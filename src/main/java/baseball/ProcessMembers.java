package baseball;

import java.util.ArrayList;
import java.util.List;

import DTO.DigitDto;
import camp.nextstep.edu.missionutils.Randoms;

public class ProcessMembers {

	public List<Integer> getRandomNumbers() {
		
		List<Integer> computer=new ArrayList<>();
		
    	while (computer.size()<3) {
    		
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    
    	    if (!computer.contains(randomNumber)) {
    	    	computer.add(randomNumber);
    	    }
    	}
    	System.out.println(computer);
		return computer;
	}

	public List<Integer> getDigits(String input) {
		
		int inputNum=Integer.parseInt(input);
		
		int first_digit=inputNum/100;
    	int second_digit=(inputNum%100)/10;
    	int third_digit=inputNum%10;
    	
    	DTO.DigitDto digits=new DigitDto(first_digit, second_digit, third_digit);

    	List<Integer> list=gatherDivs(digits);
    	
    	return list;
	}
	
	public List<Integer> gatherDivs(DigitDto digits) {
		
		List<Integer> list=new ArrayList<Integer>();
		
    	list.add(digits.getFirst_digit());
    	list.add(digits.getSecond_digit());
    	list.add(digits.getThird_digit());
		
    	return list;
	}
	
	public String inspection(List<Integer> computer,String input) {

		List<Integer> list=getDigits(input);
		int strike=0,ball=0;
		
		for(int i=0;i<computer.size();i++) {
			
			if(computer.get(i)==list.get(i)) {
				strike++;
			}
			if(computer.contains(list.get(i))) {
				ball++;
			}
		}
		ball=ball-strike;
		
		String result=((ball!=0?ball+"볼 ":"")+(strike!=0?strike+"스트라이크":"")).equals("")?"낫싱":(ball!=0?ball+"볼 ":"")+(strike!=0?strike+"스트라이크":"");
		
		return result;
	}
}

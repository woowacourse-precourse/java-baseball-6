package baseball;

import java.util.ArrayList;
import java.util.List;

import DTO.DigitDto;
//import DTO.DigitDto;
import camp.nextstep.edu.missionutils.Randoms;

public class ProcessMembers {
	
	private final int valid_digitCount=3;
	private final int valid_smallest=1;
	private final int valid_greatest=9;
	
	private final int first_divisor=100;
	private final int second_divisor=first_divisor/10;
	
	private final String init_result="";
	private final int init_count=0;

	public List<Integer> getRandomNumbers() {
		
		List<Integer> computer=new ArrayList<>();
		
    	while (computer.size()<valid_digitCount) {
    		
    	    int randomNumber = Randoms.pickNumberInRange(valid_smallest, valid_greatest);
    	    
    	    if (!computer.contains(randomNumber)) {
    	    	computer.add(randomNumber);
    	    }
    	}
    	//System.out.println(computer);
		return computer;
	}

	public List<Integer> getDigits(String input) {
		
		int inputNum=Integer.parseInt(input);
		int [] parsedData=parsingData(inputNum);

    	List<Integer> list=intoList(parsedData[0], parsedData[1], parsedData[2]);
    	
    	return list;
	}
	
	public int [] parsingData(int inputNum) {
		
		int first_digit=inputNum/first_divisor;
    	int second_digit=(inputNum%first_divisor)/second_divisor;
    	int third_digit=inputNum%second_divisor;
    	
    	int [] parsedData= {first_digit,second_digit,third_digit};
    	
    	return parsedData;
	}
	
	public List<Integer> intoList(int first_digit,int second_digit,int third_digit) {
		
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

		int [] ball_strike=compareLists(computer, list);
		String result=feedback(ball_strike[0], ball_strike[1]);
		
		return result;
	}
	
	public int [] compareLists(List<Integer> computer,List<Integer> list) {
		
		int ball=init_count;
		int strike=init_count;
		
		for(int i=0;i<computer.size();i++) {
			
			if(computer.get(i)==list.get(i)) {
				strike++;
			}
			if(computer.contains(list.get(i))) {
				ball++;
			}
		}
		ball=ball-strike;
		
		int [] result= {ball,strike};
		
		return result;
	}
	
	public String feedback(int ball,int strike) {
		
		String result=init_result;
		
		if(ball==init_count&&strike==init_count)
			result="낫싱";
		else if(ball!=init_count&&strike==init_count)
			result=ball+"볼";
		else if(ball==init_count&&strike!=init_count)
			result=strike+"스트라이크";
		else
			result=ball+"볼 "+strike+"스트라이크";
		
		return result;
	}
}

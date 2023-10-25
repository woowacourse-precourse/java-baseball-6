package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class DetermineNumberController {
	private String IS_TRIPLE_DIGIT_ERROR_MESSAGE = "세자리의 숫자가 아닙니다.";
	private String IN_RANGE_NUMBER_ERROR_MESSAGE = "1 ~ 9의 입력이 아닙니다.";
	private String NO_DUPLICATION_NUMBER_ERROR_MESSAGE = "중복되는 숫자가 있습니다.";

	public List<Integer> isPossibleNumber(String input){
		
		if(!isTripleDigit(input))
			throw new IllegalArgumentException(IS_TRIPLE_DIGIT_ERROR_MESSAGE);
		
		if(!inRangeNumber(input))
			throw new IllegalArgumentException(IN_RANGE_NUMBER_ERROR_MESSAGE);
		
		if(!noDuplicationNumber(input))
			throw new IllegalArgumentException(NO_DUPLICATION_NUMBER_ERROR_MESSAGE);
		
		return convertStringToNumber(input);
	}
	
	private boolean isTripleDigit(String input) {
		
		return input.length()==3 ;
	}
	
	private boolean inRangeNumber(String input) {
		
		for(int i = 0;i<input.length();i++) {
			if(input.charAt(i)<'1'||input.charAt(i)>'9')
				return false;
		}
		return true;
	}
	
	private boolean noDuplicationNumber(String input) {
		boolean []check = new boolean[10];
		for(int i = 0;i<input.length();i++) {
			if(check[input.charAt(i)-'0'])
				return false;
			else {
				check[input.charAt(i)-'0'] = true;
			}
		}
		return true;
	}
	
	private List<Integer> convertStringToNumber(String input){
		List<Integer> list = new ArrayList<>();

        for (char c : input.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        
        return list;
	}
}

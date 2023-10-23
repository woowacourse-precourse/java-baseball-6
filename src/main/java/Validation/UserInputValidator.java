package Validation;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {
	
	public void validateUserInput(String input) {
        verifyInputStringLength(input, 3);
        validateInputNumbers(input);
        validateDistinctNumbers(input);
    }
	
	  public void validateGameChoice(int choice) {
	        if (choice != 1 && choice != 2) {
	            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	        }
	  }
	
	 public void verifyInputStringLength(String inputString, int verify) {
	    	if(inputString.length() != verify) {
	    		throw new IllegalArgumentException("3자리 숫자만 가능합니다");
	    	}
	    }
	    
	    public void validateInputNumbers(String input) {
	    	
	    	for(int i = 0; i <input.length(); i++) {
				if(input.charAt(i) < '1' || input.charAt(i) > '9') {
					throw new IllegalArgumentException("잘못된 수를 입력하셨네요");
					
				}
			}
	    }
	    
	    public void validateDistinctNumbers(String input) {
	        Set<Character> distinctNumbers = new HashSet<>();
	        for (char c : input.toCharArray()) {
	            distinctNumbers.add(c);
	        }
	        
	        if (distinctNumbers.size() != 3) {
	            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
	        }
	    }

}

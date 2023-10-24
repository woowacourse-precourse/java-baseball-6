package Validation;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator implements InputValidator {
	
	// 사용자의 입력시 예외처리 메소드 3개를 한번에 사용할 수 있는 메소드
	@Override
	public void validate(String guess) {
        verifyInputStringLength(guess, 3);
        validateInputNumbers(guess);
        validateDistinctNumbers(guess);
    }
	
	// 게임을 재시작 할 시 1번과 2번 외에 다른 숫자를 입력하는 예외처리
	  public void validateGameChoice(int choice) {
	        if (choice != 1 && choice != 2) {
	            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	        }
	  }
	
	  // 사용자의 숫자가 3자리가 아니면 예외처리
	 public void verifyInputStringLength(String inputString, int expectedLength) {
	    	if(inputString.length() != expectedLength) {
	    		throw new IllegalArgumentException("입력은 " + expectedLength + "자리여야 합니다.");
	    	}
	    }
	    // 사용자의 숫자가 1또는 9여야 하는데 그 외에 숫자 입력시 예외처리
	    public void validateInputNumbers(String input) {
	    	for(int i = 0; i <input.length(); i++) {
				if(input.charAt(i) < '1' || input.charAt(i) > '9') {
					throw new IllegalArgumentException("잘못된 숫자를 입력하셨네요");
					
				}
			}
	    }
	    
	    // 같은 숫자가 나올시 예외처리
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

package baseball.service;

import static baseball.domain.Computer.BASEBALL_NUMBERS_SIZE;

import java.util.HashSet;
import java.util.Set;

public class PlayerService {
    
    public void validate(String number) {
        validateInteger(number);
        validateSize(number);
        validateRange(number);
        validateDuplicate(number);
    }
    
    public void validateOption(String number) {
        validateInteger(number);
    }
    
    private void validateInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }
    
    private void validateSize(String number) {
        if (number.length() != BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "%d개의 자릿수만 허용됩니다.", BASEBALL_NUMBERS_SIZE));
        }
    }
    
    private void validateRange(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int targetNumber = Character.getNumericValue(c);
            if (targetNumber <= 0 || targetNumber > 9) {
                throw new IllegalArgumentException("한 자리 자연수만 입력할 수 있습니다");
            }
        }
    }
    
    private void validateDuplicate(String number) {
        StringBuilder sb = new StringBuilder();
        Set<Character> numSet = new HashSet<>();
        
        for (char c : number.toCharArray()) {
            if (numSet.add(c)) {
                sb.append(c);
            }
        }
        
        if (number.length() != sb.length()) {
            throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다.");
        }
    }
}

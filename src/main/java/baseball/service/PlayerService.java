package baseball.service;

import static baseball.domain.Computer.BASEBALL_NUMBERS_SIZE;

public class PlayerService {
    
    public void validate(String number) {
        validateInteger(number);
        validateSize(number);
        validateDuplicate(number);
        
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
    
    private void validateDuplicate(String number) {
        if (number.length() != BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다.");
        }
    }
}

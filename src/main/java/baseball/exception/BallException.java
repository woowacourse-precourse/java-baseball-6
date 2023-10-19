package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class BallException {
    private final int BALL_SIZE = 3;
    private final Set<Character> set = new HashSet<>();

    public void validation(String number){
        notNumberValidation(number);
        ballSizeValidation(number);
        numberDuplicateValidation(number);
    }

    private void notNumberValidation(String number){
        char[] charArray = number.toCharArray();
        for (char num : charArray) {
            if ('0' >= num || num > '9'){
                throw new IllegalArgumentException("1~9까지의 숫자를 입력해주세요.");
            }
        }
    }

    private void ballSizeValidation(String number){
        if (number.length() != BALL_SIZE){
            throw new IllegalArgumentException("숫자는 3개만 입력해주세요.");
        }
    }

    private void numberDuplicateValidation(String number){
        char[] charArray = number.toCharArray();
        for (char num : charArray) {
            set.add(num);
        }
        if (set.size() != BALL_SIZE){
            throw new IllegalArgumentException("숫자는 중복없이 입력해주세요.");
        }
    }
}

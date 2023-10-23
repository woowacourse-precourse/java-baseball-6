package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    //사용자 입력 검증
    public void gameValidation(String input) {
        List<String> userInput = new ArrayList<>();

        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split("");

        for (String s :
                inputs) {
            if (s.charAt(0) < '1' || s.charAt(0) > '9') {
                throw new IllegalArgumentException();
            }

            if (userInput.contains(s)) {
                throw new IllegalArgumentException();
            }

            userInput.add(s);
        }
    }

    //재시작 입력 검증
    public void retryValidation(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }

        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}

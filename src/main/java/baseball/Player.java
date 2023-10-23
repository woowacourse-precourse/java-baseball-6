package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> makeGuess(String input) {
        List<Integer> guess = new ArrayList<>();
        validateInput(input, guess);

        return guess;
    }

    private void validateInput(String input, List<Integer> guess) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!isValid(input.charAt(i))) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (guess.contains(input.charAt(i) - '0')) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            }
            guess.add(input.charAt(i) - '0');
        }
    }

    public boolean isValid(char c) {
        return c >= '1' && c <= '9';
    }
}

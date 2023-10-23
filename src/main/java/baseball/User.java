package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> guess;

    public List<Integer> getGuess() {
        return guess;
    }

    public void setGuess(String number) {
        String[] numbers = number.split("");
        guess = new ArrayList<>();

        for (String num : numbers) {
            if (!isDigit(num)) throw new IllegalArgumentException("입력값에 숫자가 아닌 값이 들어있습니다.");
            guess.add(Integer.parseInt(num));
        }
    }

    private boolean isDigit(String num) {
        return Character.isDigit(num.charAt(0));
    }

    public static boolean isInputNumber(List<Integer> guess) {
        return (guess.size() != 3) ? false : true;
    }
}

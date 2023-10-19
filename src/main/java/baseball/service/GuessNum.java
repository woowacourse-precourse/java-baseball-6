package baseball.service;

import java.util.List;

public class GuessNum {
    public static String getHint(List<Integer> generatedNumbers, List<Integer> userInputNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < generatedNumbers.size(); i++) {
            if (userInputNumbers.get(i).equals(generatedNumbers.get(i))) {
                strike++;
            } else if (generatedNumbers.contains(userInputNumbers.get(i))) {
                ball++;
            }
        }

        StringBuilder hint = new StringBuilder();
        if (ball > 0) {
            hint.append(ball).append("볼 ");
        }
        if (strike > 0) {
            hint.append(strike).append("스크라이크");
        }
        if (hint.length() == 0) {
            hint.append("낫싱");
        }

        return hint.toString();
    }


}

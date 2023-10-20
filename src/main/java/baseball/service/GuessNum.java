package baseball.service;

import java.util.List;

public class GuessNum {

    public int getHint(List<Integer> generatedNumbers, List<Integer> userInputNumbers) {
        int result = 0;

        for (int i = 0; i < generatedNumbers.size(); i++) {
            if (userInputNumbers.contains(generatedNumbers.get(i))) {
                result++;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> generatedNumbers, List<Integer> userInputNumbers) {
        int strike = 0;

        for (int i = 0; i < generatedNumbers.size(); i++) {
            if (generatedNumbers.get(i) == userInputNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public String Confirm(List<Integer> generatedNumbers, List<Integer> userInputNumbers) {
        int total = getHint(generatedNumbers, userInputNumbers);
        int strike = countStrike(generatedNumbers, userInputNumbers);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}

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

        return strike + " strike, " + ball + " ball";
    }

}

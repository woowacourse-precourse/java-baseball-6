package baseball.service;

import baseball.console.Output;

import java.util.HashSet;

import static baseball.constants.Constants.NUMBER_LENGTH;
import static baseball.constants.Constants.REQUIRED_STRIKES_FOR_WIN;

class GameLogic {

    public boolean isGuessCorrect(String number, String answer) {
        int strike = countStrike(number, answer);
        int ball = countBall(number, answer);
        Output.print(ball, strike);

        return strike == REQUIRED_STRIKES_FOR_WIN.getValue();
    }

    public int countBall(String number, String answer) {
        HashSet<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        int ballCount = 0;
        for (int index = 0; index < NUMBER_LENGTH.getValue(); index++) {
            if (number.charAt(index) != answer.charAt(index) && set.contains(number.charAt(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrike(String number, String answer) {
        if (number.equals(answer)) {
            return REQUIRED_STRIKES_FOR_WIN.getValue();
        }

        int strikeCount = 0;
        for (int index = 0; index < NUMBER_LENGTH.getValue(); index++) {
            if (number.charAt(index) == answer.charAt(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

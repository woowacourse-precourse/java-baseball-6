package baseball;

import java.util.List;

/**
 * 규칙에 따라 스트라이크, 볼을 판단하는 클래스입니다.
 */
public class Referee {
    private final Rule rule;

    public Referee(Rule rule) {
        this.rule = rule;
    }

    public int[] compareNumbers(List<Integer> randomNumbers, int userNumber) {
        int strike = 0;
        int ball = 0;

        String userNumberStr = String.valueOf(userNumber);
        for (int i = 0; i < rule.getNumberOfDigits(); i++) {
            int userDigit = Character.getNumericValue(userNumberStr.charAt(i));
            if (randomNumbers.get(i) == userDigit) {
                strike++;
            } else if (randomNumbers.contains(userDigit)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
}

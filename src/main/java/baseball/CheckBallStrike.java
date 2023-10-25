package baseball;

import java.util.List;

public class CheckBallStrike {
    public int checkBallStrike(List<Integer> computerNumbers, String userNumber) {
        int ball = 0;
        int strike = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Constant.INPUT_LENGTH; i++) {
            if (computerNumbers.get(i) == userNumber.charAt(i) - '0') {
                strike++;
                continue;
            }
            if (computerNumbers.contains(userNumber.charAt(i)-'0')) {
                ball++;
            }
        }
        if (ball != 0) {
            result.append(ball + "볼 ");
        }
        if (strike != 0) {
            result.append(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            result.append("낫싱");
        }
        if (strike != Constant.MAX_STRIKE) {
            System.out.println(result.toString().trim());
        }
        return strike;
    }
}
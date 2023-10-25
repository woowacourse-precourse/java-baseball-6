package baseball;

import static baseball.Number.SIZE;

import java.util.List;

public class Referee {

    public String compare(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < SIZE; i++) {
            if (checkIfStrike(computerNum, userNum, i)) {
                strike++;
            }
            if (checkIfBall(computerNum, userNum, i)) {
                ball++;
            }
        }
        if (checkNothing(strike, ball)) {
            return "낫싱";
        }
        return makeResult(strike, ball);
    }

    public String makeResult(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }

    private boolean checkNothing(int strike, int ball) {
        return ball == 0 && strike == 0;
    }

    private boolean checkIfStrike(List<Integer> computerNum, List<Integer> userNum, int numIdx) {
        return computerNum.get(numIdx).equals(userNum.get(numIdx));
    }

    private boolean checkIfBall(List<Integer> computerNum, List<Integer> userNum, int numIdx) {
        return !checkIfStrike(computerNum, userNum, numIdx) && computerNum.contains(userNum.get(numIdx));
    }
}

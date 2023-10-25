package baseball.controller;

import java.util.List;

public class ScoreHandler {
    private int strike = 0, ball = 0;

    public void ScoreHandler(List<Integer> computer, List<Integer> player) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            int playerDigit = player.get(i);
            int computerDigit = computer.get(i);

            if (playerDigit == computerDigit) {
                strike++; // 메서드로 뽑아내기
            } else if (computer.contains(playerDigit)) {
                ball++; // 메서드로 뽑아내기
            }
        }
    }

    public boolean isThreeStrikes() {
        if (strike == 3) return true;
        else return false;
    }


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }


}

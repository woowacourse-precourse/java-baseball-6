package baseball.entity;

import java.util.List;
import java.util.Objects;

public class Referee {

    static final int THREE_STRIKE = 3;
    private int strike;
    private int ball;
    public Referee() {
    }

    public String result(Player firstPlayer, Player secondPlayer) {
        calculateStrikeAndBall(firstPlayer.getNumbersList(), secondPlayer.getNumbersList());
        return getResult();
    }

    private void calculateStrikeAndBall(List<Integer> playerOneNumbers,
            List<Integer> playerTwoNumbers) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < playerOneNumbers.size(); i++) {
            Integer playerOneNumber = playerOneNumbers.get(i);
            if (Objects.equals(playerOneNumber, playerTwoNumbers.get(i))) {
                strikeCnt++;
            } else if (playerTwoNumbers.contains(playerOneNumber)) {
                ballCnt ++;
            }
        }
        strike = strikeCnt;
        ball = ballCnt;
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }

    public boolean isGameOver() {
        return strike == THREE_STRIKE;
    }
}

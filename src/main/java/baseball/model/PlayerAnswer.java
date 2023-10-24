package baseball.model;

import java.util.List;

public class PlayerAnswer {

    private int ball = 0;
    private int strike = 0;


    public void countStrikeAndBall(List<Integer> computerRandomNumberList, List<Integer> playerNumberList, int i) {
        if (computerRandomNumberList.get(i) == playerNumberList.get(i)) {
            strike++;
        }
        if (computerRandomNumberList.get(i) != playerNumberList.get(i)) {
            if (computerRandomNumberList.contains(playerNumberList.get(i))) {
                ball++;
            }
        }
    }

    public void initCountZero() {
        strike = 0;
        ball = 0;
    }

    public boolean checkThreeStrike() {
        return strike == 3;
    }

    public String getHint() {
        String hint = "";

        if (ball > 0) {
            hint += ball + "볼 ";
        }
        if (strike > 0) {
            hint += strike + "스트라이크";
        }

        return hint.equals("") ? "낫싱" : hint;
    }


}

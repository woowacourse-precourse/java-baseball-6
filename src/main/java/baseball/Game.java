package baseball;

import java.util.List;

public class Game {
    private int ball = 0;
    private int strike = 0;

    public void ballCount(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
    }

    public String getResult(List<Integer> computer, List<Integer> player) {
        String result = "";
        ballCount(computer, player);

        if (strike == 3) {
            result = "3스트라이크";
        } else if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else {
            if (ball > 0) {
                result += ball + "볼 ";
            }
            if (strike > 0) {
                result += strike + "스트라이크";
            }
        }
        ball = 0;
        strike = 0;

        return result;
    }
}
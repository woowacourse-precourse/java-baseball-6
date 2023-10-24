package baseball;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    int strike;
    int ball;

    public int CountStrike(List<Integer> player, List<Integer> computer) {
        strike = 0;
        for (int i = 0; i < Constant.gameNumberLength; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int CountBall(List<Integer> player, List<Integer> computer) {
        ball = 0;
        for (int i = 0; i < Constant.gameNumberLength; i++) {
            if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public String CountResult(List<Integer> player, List<Integer> computer) {
        strike = CountStrike(player,computer);
        ball = CountBall(player,computer);
        List<String> result = new ArrayList<>();

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (ball != 0) {
            result.add(Integer.toString(ball));
            result.add("볼 ");
        }

        if (strike != 0) {
            result.add(Integer.toString(strike));
            result.add("스트라이크");
        }

        return String.join("",result);
    }
}
package baseball.Game;

import baseball.Util.Constant;
import java.util.ArrayList;
import java.util.List;

public class Compare {
    int strike;
    int ball;

    public int CountStrike(List<Integer> player, List<Integer> computer) {
        // 스트라이크 개수 확인하는 메소드
        strike = 0;
        for (int i = 0; i < Constant.GAME_NUMBER_LENGTH; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int CountBall(List<Integer> player, List<Integer> computer) {
        // 볼 개수 확인하는 메소드
        ball = 0;
        for (int i = 0; i < Constant.GAME_NUMBER_LENGTH; i++) {
            if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public String CountResult(List<Integer> player, List<Integer> computer) {
        // 스트라이크와 볼 개수를 취합하여 String으로 출력하는 메소드
        strike = CountStrike(player, computer);
        ball = CountBall(player, computer);
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

        return String.join("", result);
    }
}
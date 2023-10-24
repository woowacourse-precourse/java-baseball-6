package baseball;

import java.util.List;

public class Compare {
    int strike;
    int ball;

    public int CountStrike(
            List<Integer> player,
            List<Integer> computer
    ) {
        strike = 0;
        for (int i=0;i<3;i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int CountBall(
            List<Integer> player,
            List<Integer> computer
    ) {
        ball = 0;
        for (int i=0;i<3;i++) {
            if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public String CountResult(
            List<Integer> player,
            List<Integer> computer
    ) {
        strike = CountStrike(player,computer);
        ball = CountBall(player,computer);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike==0) {
            return ball+"볼";
        } else if (ball==0) {
            return strike+"스트라이크";
        }
        return ball+"볼 "+strike+"스트라이크";
    }
}
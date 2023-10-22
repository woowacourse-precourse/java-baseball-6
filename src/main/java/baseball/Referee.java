package baseball;

import java.util.List;
import java.util.Objects;

public class Referee {
    private int ball;
    private int strike;


    public static Referee createReferee(int ball, int strike) {
        return new Referee(0, 0);
    }

    private Referee(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void strikeAndBallCheck(List<Integer> computerNums, List<Integer> playerNums) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNums.get(i), playerNums.get(i))) {
                strike++;
                continue;
            }
            if (computerNums.contains(playerNums.get(i))) {
                ball++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean resultPhrase(int ball, int strike) {
        StringBuilder answer = new StringBuilder();
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        if (ball != 0) {
            answer.append(ball).append("볼 ");
        }
        if (strike != 0) {
            answer.append(strike).append("스트라이크");
        }
        System.out.println(answer.toString().trim());
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }
}

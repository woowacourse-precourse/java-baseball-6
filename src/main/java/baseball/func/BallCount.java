package baseball.func;

import java.util.List;

public class BallCount {
    public boolean userCount(int[] userScore, List<Integer> computerScore) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userScore[i] == computerScore.get(i)) {
                strike++;
            } else if (computerScore.contains(userScore[i])) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.println(strike + "스트라이크");
            }
        }

        return false;
    }
}

package baseball.service;

import java.util.List;

public class BaseballService {
    public int countStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (!computer.get(i).equals(user.get(i)) && computer.contains(user.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public void printBaseball(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);

        } else if (strikes > 0 && balls == 0) {
            System.out.printf("%d스트라이크\n", strikes);

        } else if (balls > 0 && strikes == 0) {
            System.out.printf("%d볼\n", balls);
        } else {
            System.out.println("낫싱");
        }
    }
}

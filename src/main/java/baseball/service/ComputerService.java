package baseball.service;

import java.util.List;

public class ComputerService {


    public static int countStrike(List<Integer> playerInput, List<Integer> computerAnswer) {
        int strike = 0;
        for (int i = 0; i < computerAnswer.size(); i++) {
            int cur = playerInput.get(i);
            if (computerAnswer.contains(cur) && computerAnswer.indexOf(cur) == i) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBall(List<Integer> playerInput, List<Integer> computerAnswer) {
        int ball = 0;
        for (int i = 0; i < computerAnswer.size(); i++) {
            int cur = playerInput.get(i);
            if (computerAnswer.contains(cur) && computerAnswer.indexOf(cur) != i) {
                ball++;
            }
        }
        return ball;
    }
}

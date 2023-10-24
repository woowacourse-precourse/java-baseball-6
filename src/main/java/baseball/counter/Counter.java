package baseball.counter;

import java.util.List;

public class Counter {
    public static CountResult countStrikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);

            if (computerNumber == playerNumber) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(playerNumber)) {
                ball++;
            }
        }

        return new CountResult(strike, ball);
    }
}

package baseball.domain;

import java.util.List;

public class Referee {

    public List<Integer> countBallAndStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i) == computerNumbers.get(i)) {
                strike++;
                continue;
            }
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return List.of(ball, strike);
    }
}
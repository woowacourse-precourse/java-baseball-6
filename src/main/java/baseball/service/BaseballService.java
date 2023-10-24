package baseball.service;

import baseball.domain.Baseball;

import java.util.List;

public class BaseballService {

    public List<Integer> getBallAndStrikeNumber(Baseball baseball, int input) {
        int ballNumber = baseball.getBallNumber(input);
        int strikeNumber = baseball.getStrikeNumber(input);

        return List.of(ballNumber, strikeNumber);
    }

    public boolean checkEquals(Baseball baseball, int input) {
        return baseball.equals(input);
    }

    public boolean checkNothing(Baseball baseball, int input) {
        return baseball.checkNothing(input);
    }
}

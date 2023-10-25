package baseball.entity;

import java.util.List;
import java.util.Objects;

public class Referee {

    boolean threeStrike = false;
    private UserPlayer userPlayerOne;
    private UserPlayer userPlayerTwo;

    public Referee() {
    }

    public Referee(UserPlayer userPlayerOne, UserPlayer userPlayerTwo) {
        this.userPlayerOne = userPlayerOne;
        this.userPlayerTwo = userPlayerTwo;
    }

    public String result() {
        GameResult gameResult = calculateStrikeAndBall(userPlayerOne.getNumbersList(),
                userPlayerTwo.getNumbersList());

        if (gameResult.isThreeStrike()) {
            threeStrike = true;
        }

        return gameResult.getResult();
    }

    private GameResult calculateStrikeAndBall(List<Integer> playerOneNumbers,
            List<Integer> playerTwoNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < playerOneNumbers.size(); i++) {
            Integer playerOneNumber = playerOneNumbers.get(i);
            if (Objects.equals(playerOneNumber, playerTwoNumbers.get(i))) {
                strike++;
            } else if (playerTwoNumbers.contains(playerOneNumber)) {
                ball += 1;
            }
        }
        return new GameResult(strike, ball);
    }

    public boolean isThreeStrike() {
        return threeStrike;
    }
}

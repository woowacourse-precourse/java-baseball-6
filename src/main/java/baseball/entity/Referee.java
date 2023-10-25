package baseball.entity;

import java.util.List;
import java.util.Objects;

public class Referee {

    boolean threeStrike = false;
    private Player firstPlayer;
    private Player secondPlayer;

    public Referee() {
    }

    public Referee(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String result() {
        GameResult gameResult = calculateStrikeAndBall(firstPlayer.getNumbersList(),
                secondPlayer.getNumbersList());

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

    public boolean isGameOver() {
        return threeStrike;
    }
}

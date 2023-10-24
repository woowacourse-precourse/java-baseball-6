package baseball;

import java.util.List;

public class BaseballGame implements NumberGame {

    private NumberGameConfiguration baseballGameConfiguration;

    public BaseballGame(NumberGameConfiguration baseballGameConfiguration) {
        this.baseballGameConfiguration = baseballGameConfiguration;
    }

    @Override
    public void play() {
        while (true) {
            proceedGame();
        }
    }

    private void proceedGame() {
        List<Integer> randomNumber = NumberFactory.createByComputer(baseballGameConfiguration);

        while (true) {
            List<Integer> userGuessNumber = NumberFactory.createByUser();
            Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
        }

    }
}

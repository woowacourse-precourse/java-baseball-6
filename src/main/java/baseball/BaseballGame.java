package baseball;

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
        Number randomNumber = NumberFactory.createByComputer(baseballGameConfiguration);

        while (true) {
            Number userGuessNumber = NumberFactory.createByUser();
        }

    }
}

package baseball;

public class BaseballGame {
    private ComputerNumber computerNum;
    private static PlayerNumber playerNum;
    private CompareScore validator;

    public BaseballGame() {
        computerNum = new ComputerNumber();
        validator = new CompareScore();
    }

    public void play() {
        do {
            getNumberFromPlayer();
            OutputView.printScoreMessage(getCompareNumber());
        } while (!isGameSet());


    }

    public void getNumberFromPlayer() {
        playerNum = new PlayerNumber(InputView.readPlayerNumber());
    }

    public int[] getCompareNumber() {
        return validator.getNumberCompare(playerNum.getPlayerNumber(), computerNum.getComputerNumber());
    }

    public boolean isGameSet() {
        if (validator.isSuccess()) {
            OutputView.printGameEndMessage();
            return true;
        }
        return false;
    }

}

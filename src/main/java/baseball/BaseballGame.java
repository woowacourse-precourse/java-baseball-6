package baseball;

public class BaseballGame {
    private ComputerNumber computerNum;
    private static PlayerNumber playerNum;
    private Validator validator;

    public BaseballGame() {
        computerNum = new ComputerNumber();
        validator = new Validator();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            OutputView.printScoreMessage(getCompareNumber());
        } while (!isGameSet());


    }

    public void getNumberFromPlayer() {
        playerNum = new PlayerNumber(InputView.setUserNumber());
        playerNum.getPlayerNumber();
    }

    public int[] getCompareNumber() {
        return validator.getNumberCompare(playerNum.getPlayerNumber(), computerNum.getComputerNumber());
    }

    public boolean isGameSet() {
        if (validator.isThreeStrike()) {
            OutputView.printGameEndMessage();
            return true;
        }
        return false;
    }

}

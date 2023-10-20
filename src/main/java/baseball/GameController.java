package baseball;

public class GameController {
    GameService gameService = new GameService();
    GameException gameException = new GameException();
    InputView inputView = new InputView();
    OutPutView outPutView = new OutPutView();

    public void play() {
        settingComputerRandomNumbers();
        playBaseBallGameLoop();
        printBaseBallGameEndMessage();
        printRetryInputNumberMessage();
        inputPlayerRetryNumber();
    }

    public void settingComputerRandomNumbers() {
        gameService.settingComputerRandomNumbers();
    }

    public void playBaseBallGameLoop() {
        gameService.playBaseBallGameLoop();
    }

    public void printBaseBallGameEndMessage() {
        outPutView.printBaseBallGameEndMessage();
    }

    public void printRetryInputNumberMessage() {
        outPutView.printRetryInputNumberMessage();
    }

    public void inputPlayerRetryNumber() {
        int retryNumber = inputView.inputPlayerRetryNumber();
        validateInputPlayerRetryNumber(retryNumber);

        if (retryNumber == 1) {
            gameService.clearComputerRandomNumber();
            play();
        }
    }

    private void validateInputPlayerRetryNumber(int retryNumber) {
        if (retryNumber != 1 && retryNumber != 2) {
            gameException.playerRetryNumberMissMatchException();
        }
    }
}
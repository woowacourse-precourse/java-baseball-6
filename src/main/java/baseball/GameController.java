package baseball;

public class GameController {
    GameService gameService = new GameService();
    GameException gameException = new GameException();
    InputView inputView = new InputView();

    public void play() {
        settingComputerRandomNumbers();
        playBaseBallGameLoop();
        inputPlayerRetryNumber();
    }

    public void settingComputerRandomNumbers() {
        gameService.settingComputerRandomNumbers();
    }

    public void playBaseBallGameLoop() {
        gameService.playBaseBallGameLoop();
    }

    public void inputPlayerRetryNumber() {
        int retryNumber = inputView.inputPlayerRetryNumber();
        if (retryNumber != 1 && retryNumber != 2) {
            gameException.playerRetryNumberMissMatchException();
        }

        if (retryNumber == 1) {
            play();
        }
    }
}
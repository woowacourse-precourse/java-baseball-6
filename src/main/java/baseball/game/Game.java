package baseball.game;

import baseball.Computer;
import baseball.user.User;

public class Game {

    private final User user;
    private final Computer computer;
    private final GameUI gameUI;
    private final GameLogic gameLogic;

    public Game(GameUI gameUI, GameLogic gameLogic, Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.gameUI = gameUI;
        this.gameLogic = gameLogic;
    }

    private String inferHint() {
        int strike = gameLogic.countStrike(user.getUserNumber(), computer.getComputerNumber());
        int ball = gameLogic.countBall(user.getUserNumber(), computer.getComputerNumber());
        return gameLogic.generateHintFromResult(strike, ball);
    }

    private void playBaseBallGame() {
        gameUI.displayStartGame();

        while (true) {
            try {
                gameUI.displayUserInput();
                user.inputUserNumber();

                String hint = inferHint();
                gameUI.displayHint(inferHint());

                if (gameLogic.isAnswer(hint)) {
                    gameUI.displayCorrectAnswerMessage();

                    user.inputUserStatus();
                    if (gameLogic.isQuitGame(user.getUserStatus())) {
                        break;
                    }

                    computer.resetComputerNumber();
                }
            } catch (IllegalArgumentException e) {
                gameUI.displayExceptionMessage(e);
                throw e;
            }
        }
    }

    public void startGame() {
        playBaseBallGame();
    }
}
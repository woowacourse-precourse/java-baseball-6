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

    public void startGame() {
        try {
            playBaseballGame();
        } catch (IllegalArgumentException e) {
            gameUI.displayExceptionMessage(e);
            throw e;
        }
    }

    private String playSingleRound() {
        gameUI.displayUserInput();
        user.inputUserNumber();

        String hint = inferHint();
        gameUI.displayHint(hint);

        return hint;
    }

    private void playGameUntilCorrect() {
        String hint;

        do {
            hint = playSingleRound();
        } while (!gameLogic.isAnswer(hint));

        gameUI.displayCorrectAnswerMessage();
    }

    private void playBaseballGame() {
        gameUI.displayStartGame();

        while (true) {
            playGameUntilCorrect();

            user.inputUserStatus();

            if (gameLogic.isQuitGame(user.getUserStatus())) {
                break;
            }

            computer.resetComputerNumber();
        }
    }
}
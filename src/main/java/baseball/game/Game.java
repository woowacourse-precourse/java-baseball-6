package baseball.game;

import baseball.Computer;
import baseball.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.game.GameUI.displayCorrectAnswerMessage;

public class Game {
    private User user;
    private Computer computer;
    private final GameUI gameUI;
    private final GameLogic gameLogic;

    public Game(GameUI gameUI, GameLogic gameLogic) {
        this.computer = new Computer();
        this.user = new User();
        this.gameUI = gameUI;
        this.gameLogic = gameLogic;
    }

    private static boolean isWantToQuitGame() {
        int exitCommand = Integer.parseInt(Console.readLine());
        return exitCommand == 2;
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
                gameUI.diplayUserInput();
                user.inputUserNumber();
                gameLogic.validateUserInput(user.getUserNumber());

                String hint = inferHint();
                gameUI.displayHint(inferHint());

                if (gameLogic.isAnswer(hint)) {
                    displayCorrectAnswerMessage();
                    if (isWantToQuitGame()) {
                        break;
                    } else {
                        computer.resetComputerNumber();
                    }
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
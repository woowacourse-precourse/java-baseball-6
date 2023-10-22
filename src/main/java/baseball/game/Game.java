package baseball.game;

import baseball.Computer;
import baseball.User;
import baseball.validators.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.game.GameUI.displayCorrectAnswerMessage;

public class Game {
    private User user;
    private Computer computer;
    private final List<Validator> validators;
    private final GameUI gameUI;

    public Game(List<Validator> validators, GameUI gameUI) {
        this.computer = new Computer();
        this.user = new User();
        this.validators = validators;
        this.gameUI = gameUI;
    }

    private void validateUserInput() {
        for (Validator validator : validators) {
            validator.validate(user.getUserNumber());
        }
    }

    public int countStrike() {
        int result = 0;
        String userNumber = user.getUserNumber();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();

        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 == computerNumber.get(i)) {
                result++;
            }
        }
        return result;
    }

    public int countBall() {
        int result = 0;
        String userNumber = user.getUserNumber();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();

        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 != computerNumber.get(i) && computerNumber.contains(userNumber.charAt(i) - 48)) {
                result++;
            }
        }
        return result;
    }


    private static boolean isWantToQuitGame() {
        int exitCommand = Integer.parseInt(Console.readLine());
        return exitCommand == 2;
    }

    private String inferHint() {
        int strike = countStrike();
        int ball = countBall();
        return getResult(strike, ball);
    }

    private String getResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return GameHintType.NOTHING.getLabel();
        }

        String strikeResult = getGameResult(GameHintType.STRIKE, strike);
        String ballResult = getGameResult(GameHintType.BALL, ball);
        return ballResult + strikeResult;
    }

    private String getGameResult(GameHintType hintType, int count) {
        if (count <= 0) return "";

        return switch (hintType) {
            case STRIKE, BALL -> String.format("%d%s", count, hintType.getLabel());
            case NOTHING -> "";
        };
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean isAnswer(String hint) {
        return hint.equals("3스트라이크");
    }

    private void playBaseBallGame() {
        gameUI.displayStartGame();

        while (true) {
            try {
                gameUI.diplayUserInput();
                user.inputUserNumber();
                validateUserInput();

                String hint = inferHint();
                gameUI.displayHint(hint);

                if (isAnswer(hint)) {
                    displayCorrectAnswerMessage();
                    if (isWantToQuitGame()) {
                        break;
                    }
                    this.computer = new Computer();
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
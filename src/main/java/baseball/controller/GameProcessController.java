package baseball.controller;

import baseball.model.IsGameClear;
import baseball.model.RandomNumberCreator;
import baseball.model.UserNumberChecker;
import baseball.model.UserNumberGrader;
import baseball.view.MessageOutputView;
import baseball.view.UserInputView;


public class GameProcessController {
    private final RandomNumberCreator answer;
    private static UserNumberChecker userNumber;
    private final UserNumberGrader grade;
    private static IsGameClear clear;

    public GameProcessController() {
        answer = new RandomNumberCreator();
        answer.setRandomNumber();
        userNumber = new UserNumberChecker();
        grade = new UserNumberGrader();
        clear = new IsGameClear(grade);
    }

    public void startGame() {
        do {
            userNumber.updateUserNumber(UserInputView.setInputNumber());
            gradeMessage(gradeBallStrike());
        } while (!endGame());
    }

    public boolean endGame() {
        boolean gameClear = clear.getResultGrade(userNumber.getUserNumber(), answer.getAnswer());
        return gameClear;
    }

    public int[] gradeBallStrike() {
        return grade.grader(userNumber.getUserNumber(), answer.getAnswer());
    }

    public void gradeMessage(int[] ballStrike) {
        ballMessage(ballStrike);
        ballStrikeMessage(ballStrike);
        strikeMessage(ballStrike);
        nothingMessage(ballStrike);
        endGameMessage(ballStrike);
    }

    public static void ballMessage(int[] ballStrike) {
        if (ballStrike[0] != 0 && ballStrike[1] == 0) {
            MessageOutputView.ballStrikeCountMessage(ballStrike[0]);
            MessageOutputView.ballMessage();
        }
    }

    public static void ballStrikeMessage(int[] ballStrike) {
        if (ballStrike[0] != 0 && ballStrike[1] != 0) {
            MessageOutputView.ballStrikeCountMessage(ballStrike[0]);
            MessageOutputView.ballSpaceMessage();
            MessageOutputView.ballStrikeCountMessage(ballStrike[1]);
            MessageOutputView.strikeMessage();
        }
    }

    public static void strikeMessage(int[] ballStrike) {
        if (ballStrike[0] == 0 && ballStrike[1] != 0) {
            MessageOutputView.ballStrikeCountMessage(ballStrike[1]);
            MessageOutputView.strikeMessage();
        }
    }

    public static void nothingMessage(int[] ballStrike) {
        if (ballStrike[0] == 0 && ballStrike[1] == 0) {
            MessageOutputView.incorrectAnswerMessage();
        }
    }

    public static void endGameMessage(int[] ballStrike) {
        if (ballStrike[1] == 3) {
            MessageOutputView.endGameMessage();
        }
    }
}
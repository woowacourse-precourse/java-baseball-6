package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;

import java.util.List;

public class User {

    private final NumberBaseballIO numberBaseballIO;

    public User(NumberBaseballIO numberBaseballIO) {
        this.numberBaseballIO = numberBaseballIO;
    }

    public List<Integer> guessAnswer(int numberLength) {
        return numberBaseballIO.inputGuessAnswer(numberLength);
    }

    public void guessUntilCorrect(Answer answer) {
        Answer userAnswer = null;
        Result result;

        while (!answer.isCorrect(userAnswer)) {
            userAnswer = guessAnswer(answer);
            result = Result.create(answer,userAnswer);
            result.showResult(numberBaseballIO);
        }
    }

    private Answer guessAnswer(Answer answer) {
        return Answer.createByList(numberBaseballIO.inputGuessAnswer(answer.getSize()));
    }

    public boolean isContinueGame(int numberLimit) {
        int userChoice = numberBaseballIO.showAndReceiveContinueGame(numberLimit);
        return userChoice == NumberBaseballConstants.CONTINUE_GAME;
    }
}

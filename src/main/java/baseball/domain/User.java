package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;

public class User {

    private final NumberBaseballIO numberBaseballIO;

    public User(NumberBaseballIO numberBaseballIO) {
        this.numberBaseballIO = numberBaseballIO;
    }

    public void guessUntilCorrect(Answer answer) {
        Result result;

        do {
            Answer userAnswer = guessAnswer(answer.getSize());
            result = Result.create(answer, userAnswer);
            numberBaseballIO.printResult(result);
        }while (!result.isCorrect());
    }

    private Answer guessAnswer(int numberLength) {
        return Answer.createByList(numberBaseballIO.inputGuessAnswer(numberLength));
    }

    public boolean isContinueGame(int numberLimit) {
        int userChoice = numberBaseballIO.showAndReceiveContinueGame(numberLimit);
        return userChoice == NumberBaseballConstants.CONTINUE_GAME;
    }
}

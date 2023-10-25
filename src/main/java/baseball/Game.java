package baseball;

import baseball.domain.Computer;
import baseball.domain.GameElements;
import baseball.domain.User;
import java.util.List;

public class Game {
    private static final int STRIKE_COUNT_FOR_WIN = 3;
    private static final int PLAY_AGAIN = 1;

    Computer computer = new Computer();
    User user = new User();
    GameElements gameElements = new GameElements();

    public void startGame() {
        runGame();
        askForPlayAgain();
    }

    private void runGame() {
        List<Integer> answerNumberList = computer.createAnswerNumberList();
        gamingUtilWin(answerNumberList);
        View.printGameEndMessage();
    }

    private void gamingUtilWin(List<Integer> answerNumberList) {
        List<Integer> userNumberList;

        while (gameElements.getStrike() < STRIKE_COUNT_FOR_WIN) {
            gameElements.resetElements();
            userNumberList = user.getThreeDigitNumberForUser();
            compareNumbers(answerNumberList, userNumberList);
        }
    }

    private void compareNumbers(List<Integer> answerNumberList, List<Integer> userNumberList) {
        for (int oneDigit = 0; oneDigit < answerNumberList.size(); oneDigit++) {
            checkBallAndStrike(answerNumberList, answerNumberList.get(oneDigit), userNumberList.get(oneDigit));
        }

        checkResult();
    }

    private void checkBallAndStrike(List<Integer> answerNumberList, int answerNumber, int userNumber) {
        if (answerNumber == userNumber) {
            gameElements.incrementStrike();
        }

        if (answerNumberList.contains(userNumber) && answerNumber != userNumber) {
            gameElements.incrementBall();
        }
    }

    private void checkResult() {
        judgeNothing(gameElements);
        judgeOnlyBall(gameElements);
        judgeOnlyStrike(gameElements);
        judgeBallAndStrike(gameElements);
    }

    private void judgeNothing(GameElements gameElements) {
        if (gameElements.getStrike() == 0 && gameElements.getBall() == 0) {
            View.printNothingMessage();
        }
    }

    private void judgeOnlyBall(GameElements gameElements) {
        if (gameElements.getStrike() == 0 && gameElements.getBall() != 0) {
            View.printBallMessage(gameElements.getBall());
        }
    }

    private void judgeOnlyStrike(GameElements gameElements) {
        if (gameElements.getBall() == 0 && gameElements.getStrike() != 0) {
            View.printStrikeMessage(gameElements.getStrike());
        }
    }

    private void judgeBallAndStrike(GameElements gameElements) {
        if (gameElements.getStrike() != 0 && gameElements.getBall() != 0) {
            View.printBallAndStrikeMessage(gameElements.getBall(), gameElements.getStrike());
        }
    }

    private void askForPlayAgain() {
        View.printPlayAgain();

        if (user.getNumberForPlayAgain() == PLAY_AGAIN) {
            gameElements.resetElements();
            startGame();
        }
    }
}

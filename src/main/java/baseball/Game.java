package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;

public class Game {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() {
        View.printStartGameMessage();
        gaming();
        askToPlayAgain();
    }

    private void askToPlayAgain() {
        View.printPlayAgain();

        if (user.getNumberForPlayAgain() == 1) {
            startGame();
        }else {
            return;
        }
    }

    private void gaming() {
        List<Integer> answerNumberList = computer.createAnswerNumberList();
        gamingUtilWin(answerNumberList);
        View.printGameEndMessage();
    }

    private void gamingUtilWin(List<Integer> answerNumberList) {
        List<Integer> userNumberList;
        int strike = 0;

        while (strike < 3) {
            userNumberList = user.getThreeDigitNumberForUser();
            strike = compareNumbers(answerNumberList, userNumberList);
        }
    }

    private int compareNumbers(List<Integer> answerNumberList, List<Integer> userNumberList) {
        int ball = 0;
        int strike = 0;

        for (int oneDigit = 0; oneDigit < answerNumberList.size(); oneDigit++) {
            if (answerNumberList.get(oneDigit).equals(userNumberList.get(oneDigit))) {
                strike++;
            } else if (answerNumberList.contains(userNumberList.get(oneDigit))) {
                ball++;
            }
        }

        checkResult(ball, strike);

        return strike;
    }

    private void checkResult(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            View.printNothingMessage();
        } else if (strike == 0) {
            View.printBallMessage(ball);
        } else if (ball == 0) {
            View.printStrikeMessage(strike);
        } else {
            View.printBallAndStrikeMessage(ball, strike);
        }
    }

}

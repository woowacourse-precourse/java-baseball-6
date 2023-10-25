package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;

public class Game {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() {
        runGame();
        askToPlayAgain();
    }

    private void runGame() {
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
            checkBallAndStrike(ball, strike, answerNumberList, userNumberList.get(oneDigit));
        }

        checkResult(ball, strike);

        return strike;
    }

    private void checkBallAndStrike(int ball, int strike, List<Integer> answerNumberList, int userNumber) {
        if (answerNumberList.equals(userNumber)) {
            strike++;
        }

        if (answerNumberList.contains(userNumber)) {
            ball++;
        }

        //List 형식으로 ball과 strike를 묶어서 반환
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

    private void askToPlayAgain() {
        View.printPlayAgain();

        if (user.getNumberForPlayAgain() == 1) {
            startGame();
        }
    }
}

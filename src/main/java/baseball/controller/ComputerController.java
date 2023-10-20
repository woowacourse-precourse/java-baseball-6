package baseball.controller;

import baseball.common.RandomUtility;
import baseball.model.ComputerNumber;
import baseball.view.ProceedView;

public class ComputerController {
    private static final int NUMBER_LENGTH = 3;
    private static final int SUCCESS_STRIKE_NUMBER = 3;
    private static final String STRIKE_WORD_MESSAGE = "스트라이크";
    private static final String BALL_WORD_MESSAGE = "볼";
    private static final String NOTHING_WORD_MESSAGE = "낫싱";
    private static final String SPACE_MESSAGE = " ";
    private static final String NULL_MESSAGE = "";

    ComputerNumber computerNumber;
    RandomUtility randomUtility = new RandomUtility();
    ProceedView proceedView = new ProceedView();
    GameController gameController = new GameController();

    public void startGame() {
        computerNumber = new ComputerNumber(randomUtility.createComputerNumber());
        proceedView.proceed();
    }

    public void compareNumber(String inputNumber) {
        CountBallStrike count = countBallAndStrike(inputNumber);
        if(count.strikeNum == SUCCESS_STRIKE_NUMBER) {
            proceedView.printHint(getHintMessage(count));
            gameController.endGame();
        } else {
            proceedView.printHint(getHintMessage(count));
            proceedView.proceed();
        }
    }

    private static String getHintMessage(CountBallStrike count) {
        String hint = "";

        hint += getBallHint(count.ballNum);
        hint += getStrikeHint(count.strikeNum);
        hint += getNotingHint(count.ballNum, count.strikeNum);

        return hint;
    }

    private static String getBallHint(int ballNum) {
        if(ballNum > 0) {
            return ballNum + BALL_WORD_MESSAGE + SPACE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    private static String getStrikeHint(int strikeNum) {
        if(strikeNum > 0) {
            return strikeNum + STRIKE_WORD_MESSAGE + SPACE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    private static String getNotingHint(int ballNum, int strikeNum) {
        if(ballNum == 0 && strikeNum == 0) {
            return NOTHING_WORD_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    static class CountBallStrike {
        int ballNum;
        int strikeNum;

        CountBallStrike(int ballNum, int strikeNum) {
            this.ballNum = ballNum;
            this.strikeNum = strikeNum;
        }
    }

    private CountBallStrike countBallAndStrike(String number) {
        int ballNum = 0, strikeNum = 0;
        int[] index = computerNumber.getComputerNumberIndex();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int num = number.charAt(i) - '0';
            if (index[num] == 0)
                continue; //answer에 포함 X
            if (index[num] == i + 1) {       //같은 위치
                strikeNum++;
            } else {                    //다른 위치
                ballNum++;
            }
        }

        return new CountBallStrike(ballNum, strikeNum);
    }
}

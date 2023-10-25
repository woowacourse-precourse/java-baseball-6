package controller;

import domain.BaseBallNumbers;
import domain.RandomNumbers;
import exception.InvalidContinueMessageException;
import view.inputView;
import view.outputView;

public class BaseBallGameController {
    private static final Integer CONTINUE = 1;
    private static final Integer END = 2;
    private static final Integer THREE_STRIKE = 3;

    public static void start() {
        outputView.printGameStartMessage();
        playBaseBallGame();
    }

    // playBaseBallGame: 게임 진행
    private static void playBaseBallGame() {
        int strikeCnt = 0;
        int ballCnt = 0;
        RandomNumbers randomNumbers = new RandomNumbers();

        while (strikeCnt != THREE_STRIKE) {
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(inputView.getRequirePlayerBaseballNumbers());
            ballCnt = baseBallNumbers.calculateBallCount(randomNumbers.getRandomNumbers());
            strikeCnt = baseBallNumbers.calculateStrikeCount(randomNumbers.getRandomNumbers());
            outputView.printResult(ballCnt, strikeCnt);
        }
        outputView.printThreeStrikeMessage();
        checkContinue();
    }

    // checkContinue: 게임을 계속할 것인지 확인
    private static void checkContinue() {
        int isContinue = Integer.parseInt(inputView.askContinue());

        if (isContinue == CONTINUE) {
            playBaseBallGame();
            return;
        }
        else if (isContinue == END) {
            return;
        }
        else {
            throw new InvalidContinueMessageException();
        }

    }
}

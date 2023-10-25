package controller;

import domain.RandomNumbers;

public class BaseBallGameController {
    private static final String CONTINUE = "1";
    private static final String END = "2";
    private static final Integer THREE_STRIKE = 3;

    public static void start() {
        playBaseBallGame();
        checkContinue();
    }

    // playBaseBallGame: 게임 진행
    private static void playBaseBallGame() {
        int strikeCnt = 0;
        int ballCnt = 0;
        RandomNumbers randomNumbers = new RandomNumbers();
    }

    // checkContinue: 게임을 계속할 것인지 확인
    private static void checkContinue() {
    }
}

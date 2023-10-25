package controller;

public class BaseBallGameController {
    private static final String CONTINUE = "1";
    private static final String END = "2";
    private static final Integer THREE_STRIKE = 3;

    public static void start() {
        startBaseBallGame();
        checkContinue();
    }

    private static void startBaseBallGame() {
        int strikeCnt = 0;
        int ballCnt = 0;
    }

    private static void checkContinue() {
    }
}

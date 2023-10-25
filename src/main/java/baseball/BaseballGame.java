package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    GameHint gameHint = new GameHint();
    RandomUtils randomUtils = new RandomUtils();
    ValidAnswer validAnswer = new ValidAnswer();
    static String computerNumber;
    private static final String RETRY_SIGN = "1";
    private static final String STOP_SIGN = "2";


    public void run() {
        SystemMessage.printStartMessage();
        do {
            gamePlay();
        } while (gameRetry());
    }

    public void gamePlay() {
        computerNumber = randomUtils.getComputerNumber();
        do {
            SystemMessage.requestInputMessage();
            String userInputNumber = Console.readLine();
            String userNumber = validAnswer.getUserNumber(userInputNumber);
            gameHint.printGameHint(computerNumber, userNumber);
        } while (!gameHint.isGameOver());
    }

    public static boolean gameRetry() {
        SystemMessage.printGameOverMessage();
        SystemMessage.requestRetryMessage();
        String requestRetry = Console.readLine();
        return requestGameRetry(requestRetry).equals(RETRY_SIGN);
    }

    private static String requestGameRetry(String requestRetry) {
        if (!requestRetry.equals(RETRY_SIGN) && !requestRetry.equals(STOP_SIGN)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return requestRetry;
    }
}

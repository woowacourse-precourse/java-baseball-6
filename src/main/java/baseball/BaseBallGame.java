package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private static final int INPUT_LENGTH = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String QUIT_MESSAGE = "게임 종료";
    private static final String RESTART_NUMBER = "1";
    private static final String QUIT_NUMBER = "2";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String EXCEPTION_MESSAGE = "1 또는 2를 입력하세요.";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Computer computer = new Computer();
    private User user = new User();

    private int ballCount = 0;
    private int strikeCount = 0;


    public void start() {
        System.out.println(START_MESSAGE);
        boolean quit = false;
        computer.generateComputerBaseBallNumber();

        while (!quit) {
            user.getUserInput();
            gameResultCalculation();
            printResultMessage();
            quit = isGameEnd();
        }
    }

    private void gameResultCalculation() {
        checkStrike();
        checkBall();
    }

    private void checkStrike() {
        strikeCount = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (user.userBaseBallNumber[i] == computer.computerBaseBallNumber[i]) {
                strikeCount++;
            }
        }
    }

    private void checkBall() {
        ballCount = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            for (int j = 0; j < INPUT_LENGTH; j++) {
                if (user.userBaseBallNumber[i] == computer.computerBaseBallNumber[j] && i != j) {
                    ballCount++;
                }
            }
        }
    }

    private void printResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount > 0 && strikeCount > 0) {
            stringBuilder.append(ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE);
            System.out.println(stringBuilder);
            return;
        }
        if (ballCount > 0 && strikeCount == 0) {
            stringBuilder.append(ballCount + BALL_MESSAGE);
            System.out.println(stringBuilder);
            return;
        }
        if (ballCount == 0 && strikeCount > 0) {
            stringBuilder.append(strikeCount + STRIKE_MESSAGE);
            System.out.println(stringBuilder);
            return;
        }
        if (ballCount == 0 && strikeCount == 0) {
            stringBuilder.append(NOTHING_MESSAGE);
            System.out.println(stringBuilder);
        }
    }

    private boolean isGameEnd() {
        if (strikeCount == INPUT_LENGTH) {
            System.out.println(WIN_MESSAGE);
            return askRetry();
        }
        return false;
    }

    private boolean askRetry() {
        System.out.println(RETRY_MESSAGE);
        String quitInput = Console.readLine();

        if (quitInput.equals(RESTART_NUMBER)) {
            computer.generateComputerBaseBallNumber();
            return false;
        }
        if (quitInput.equals(QUIT_NUMBER)) {
            System.out.println(QUIT_MESSAGE);
            return true;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }
}

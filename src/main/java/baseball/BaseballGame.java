package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    public static final int RESTART_OPERATION = 1;
    public static final int EXIT_OPERATION = 2;
    int exitNumber = 0;
    int[] answerNumber = new int[3];
    int[] expectedNumber = new int[3];

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            if (isExit()) {
                return;
            }
        }
    }

    private boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        readExitNumber(readLine());

        switch (exitNumber) {
            case RESTART_OPERATION:
                break;
            case EXIT_OPERATION:
                return true;
            default:
                throw new IllegalArgumentException(RESTART_OPERATION + " 또는 " + EXIT_OPERATION + "를 입력해야 합니다.");
        }
        return false;
    }

    public void readExitNumber(String input) {
        try {
            exitNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}

package baseball;

import java.util.List;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public static void printExceptionMessage(String message) {
        System.out.println(ERROR_MESSAGE_FORMAT + message);
    }

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(List<TryResult> tryResults) {
    }

    public static void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}

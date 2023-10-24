package baseball.View;

import baseball.AnswerJudge;
import baseball.Controller.GameController;

public class OutputView {
    private static final String END_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다.";
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static boolean isWin(String result) {
        if (AnswerJudge.isWin(result)) {
            return true;
        }
        return false;
    }

    public static boolean isCon(String choice) {
        if (choice.equals(RESTART)) {
            GameController.RegenerateComputerNumber();
            return true;
        }
        if (choice.equals(EXIT)) {
            System.out.println(END_MESSAGE);
            return false;
        }
        System.out.println(ERROR_MESSAGE);
        return isCon(InputView.choice());
    }

    public static String printResult(String result) {
        System.out.println(result);
        return result;
    }
}

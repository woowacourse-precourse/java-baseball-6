package baseball.view;

import baseball.constant.OutputMessage;

public class OutputView {

    public static void showResult(String result) {
        System.out.println(result);
    }

    public void printStartGame() {
        System.out.println(OutputMessage.START_GAME);
    }

    public void printInputNumber() {
        System.out.print(OutputMessage.PLEASE_INPUT_NUMBER);
    }

    public void printRestart() {
        System.out.println(OutputMessage.RESTART_GAME);
    }
}

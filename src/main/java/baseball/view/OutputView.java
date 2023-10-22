package baseball.view;

import baseball.view.constants.PrintMessage;

public class OutputView {
    public static void printGameInformation(PrintMessage message) {
        System.out.print(message.getMessage());
    }

    public static void printResult(String resultMessage) {
        System.out.println(resultMessage);
    }
}

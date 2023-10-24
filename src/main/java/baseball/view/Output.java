package baseball.view;

import baseball.constants.MessageConstants;

public class Output {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInputMessage(String message) {
        System.out.print(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(MessageConstants.ERROR_MESSAGE + message);
    }
}

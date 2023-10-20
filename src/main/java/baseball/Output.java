package baseball;

import constants.MessageConstants;

public class Output {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(MessageConstants.ERROR_MESSAGE + message);
    }
}

package baseball;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    public static void getStartingMessage() {
        System.out.println(messages.getString("starting.message"));
    }
    public static void getInputMessage() {
        System.out.println(messages.getString("input.message"));
    }
    public static void getEndingMessage() {
        System.out.println(messages.getString("ending.message"));
    }
    public static void getRestartOrEndMessage() {
        System.out.println(messages.getString("restartOrEnd.message"));
    }

}


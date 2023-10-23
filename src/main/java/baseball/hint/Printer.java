package baseball.hint;

import baseball.constant.StatusMessage;

public class Printer {
    public static boolean isFinished(String message) {
        return message.equals(" 3" + StatusMessage.STRIKE.statusName);
    }

    public static void print(String message) {
        if (message.equals(" ")) {
            System.out.println("nothing");
            return;
        }
        System.out.println(message.strip());
    }
}

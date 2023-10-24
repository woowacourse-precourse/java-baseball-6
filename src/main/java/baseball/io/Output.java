package baseball.io;

import baseball.domain.Message;

public class Output {
    private Output() {
    }

    public static void initMsg() {
        System.out.println(Message.init());
    }

    public static void inputMsg() {
        System.out.print(Message.pending());
    }

    public static void checkResultMsg(String result) {
        System.out.println(result);
    }

    public static void correctMsg() {
        System.out.println(Message.correct());
    }

    public static void errorMsg(String message) {
        System.out.println(message);
    }

    public static void continueMsg() {
        System.out.println(Message.continueOrNot());
    }

    public static void expireMsg() {
        System.out.println(Message.expire());
    }
}

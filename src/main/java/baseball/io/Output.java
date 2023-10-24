package baseball.io;

import baseball.domain.Message;

public class Output {
    private Output() {
    }

    public static void printInit() {
        System.out.println(Message.init());
    }

    public static void printUserInput() {
        System.out.print(Message.pending());
    }

    public static void printCheckerResult(String result) {
        System.out.println(result);
    }

    public static void printCorrect() {
        System.out.println(Message.correct());
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printContinue() {
        System.out.println(Message.continueOrNot());
    }

    public static void printExpire() {
        System.out.println(Message.expire());
    }
}

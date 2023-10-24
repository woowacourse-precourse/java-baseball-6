package baseball.util;



public class PrintMessage {
    public static void printInitMessage() {
        System.out.println(Message.INIT);
    }

    public static void printInputMessage() {
        System.out.print(Message.INPUT);
    }

    public static void printBallMessage(int num) {
        System.out.println(Integer.toString(num) + Message.BALL);
    }

    public static void printStrikeMessage(int num) {
        System.out.println(Integer.toString(num) + Message.STRIKE);
    }

    public static void printNothingMessage() {
        System.out.println(Message.NOTHING);
    }

    public static void printBallAndStrikeMessage(int ballCnt, int strikeCnt) {
        System.out.println(Integer.toString(ballCnt) + Message.BALL + " " + Integer.toString(strikeCnt) + Message.STRIKE);
    }

    public static void printSuccessMessage() {
        printStrikeMessage(3);
        System.out.println(Message.SUCCESS);
    }
}

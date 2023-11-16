package baseball.game;

import baseball.game.entity.NumberBaseBallGameWord;

public class NumberBaseBallGameMessage {

    private NumberBaseBallGameMessage() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStart() {
        System.out.println(NumberBaseBallGameWord.START.getMessage());
    }

    public static void printRunning() {
        System.out.print(NumberBaseBallGameWord.RUNNING.getMessage());
    }

    public static void printContinue() {
        System.out.println(NumberBaseBallGameWord.CONTINUE.getMessage());
    }

    public static String getEndMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(NumberBaseBallGameWord.STRIKE.getMessage()).append("\n");
        sb.append(NumberBaseBallGameWord.END.getMessage());

        return sb.toString();
    }

    public static boolean isEnd(String message) {
        if (message.equals(getEndMessage())) {
            return true;
        }
        return false;
    }

    public static boolean isReStart(String message) {
        if (message.equals(NumberBaseBallGameWord.NEW_GAME.getMessage())) {
            return true;
        }
        return false;
    }

    public static boolean isExit(String message) {
        if (message.equals(NumberBaseBallGameWord.EXIT_GAME.getMessage())) {
            return true;
        }
        return false;
    }
}

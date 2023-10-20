package baseball.game;

import baseball.game.entity.NumberBaseBallGameWord;

public class NumberBaseBallGameMessage {

    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printStart() {
        System.out.println(NumberBaseBallGameWord.START.getKrName());
    }

    public static void printRunning() {
        System.out.print(NumberBaseBallGameWord.RUNNING.getKrName());
    }

    public static void printContinue() {
        System.out.println(NumberBaseBallGameWord.CONTINUE.getKrName());
    }

    private static String getEndMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(NumberBaseBallGameWord.STRIKE.getKrName()).append("\n");
        sb.append(NumberBaseBallGameWord.END.getKrName());

        return sb.toString();
    }

    public static boolean isEnd(String message) {
        if(message.equals(getEndMessage())) return true;
        return false;
    }
}

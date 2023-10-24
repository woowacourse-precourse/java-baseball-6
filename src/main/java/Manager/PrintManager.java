package Manager;

import Entity.GameResult;
import Entity.Status;

public class PrintManager {
    public static void printStatus(Status status, boolean newLine) {
        String message = status.getMessage();
        if (newLine) {
            System.out.println(message);
            return;
        }
        System.out.print(message);
    }

    public static void printGameResult(int ball, int strike) {
        String result = GameResult.getMessage(ball, strike);
        System.out.println(result);
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleHandler {
    public static String requestInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    public static void displayGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount > 0) {
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount > 0) {
                System.out.print(strikeCount + "스트라이크");
            }
            System.out.print("\n");
        }
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
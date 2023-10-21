package baseball.view;

public class OutputView {
    public static void printConsoleMessage(String message) {
        System.out.print(message);
    }

    public static void printlnConsoleMessage(String message) {
        System.out.println(message);
    }

    public static void printGameResult(int strikes, int balls) {
        hasBallsAndStrikes(strikes, balls);
        hasOnlyStrikes(strikes, balls);
        hasOnlyBalls(strikes, balls);
        hasNothing(strikes, balls);
    }

    private static void hasNothing(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
    }

    private static void hasOnlyStrikes(int strikes, int balls) {
        if (strikes > 0 && balls == 0) {
            System.out.printf("%d스트라이크%n", strikes);
        }
    }

    private static void hasOnlyBalls(int strikes, int balls) {
        if (strikes == 0 && balls > 0) {
            System.out.printf("%d볼%n", balls);
        }
    }

    private static void hasBallsAndStrikes(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크%n", strikes, balls);
        }
    }
}

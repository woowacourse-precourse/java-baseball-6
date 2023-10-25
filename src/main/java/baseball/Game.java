package baseball;

public class Game {
    public static void printGameResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            return;
        }
        if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        }
    }

}
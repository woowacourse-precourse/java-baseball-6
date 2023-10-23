package baseball.io;

public class GameResultOutput {
    public static void print(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount == 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf("%d볼\n", ballCount);
            return;
        }
        System.out.printf("%d볼 %d스트라이크", ballCount, strikeCount);
    }
}

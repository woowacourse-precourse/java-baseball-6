package baseball.utils;

public class Result {

    public static void printResult(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.printf("%d볼 %d스트라이크%n", ballCount, strikeCount);
        } else if (strikeCount > 0) {
            System.out.printf("%d스트라이크%n", strikeCount);
        } else if (ballCount > 0) {
            System.out.printf("%d볼%n", ballCount);
        } else {
            System.out.println("낫싱");
        }
    }
}

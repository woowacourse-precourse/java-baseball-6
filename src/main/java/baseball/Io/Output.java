package baseball.Io;

public class Output {

    public static void printGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }

        System.out.println();
    }
}

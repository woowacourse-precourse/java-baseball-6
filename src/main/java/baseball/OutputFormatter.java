package baseball;

public class OutputFormatter {
    public static void formatOutput(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount+"볼"+" "+strikeCount+"스트라이크");
        } else if (ballCount > 0 ){
            System.out.println(ballCount+"볼");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount+"스트라이크");
        }
    }
}

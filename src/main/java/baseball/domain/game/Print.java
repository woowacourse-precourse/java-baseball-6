package baseball.domain.game;

public class Print {
    Print(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount == 0) System.out.println(strikeCount + "스트라이크");
        else if (strikeCount == 0 && ballCount != 0) System.out.println(ballCount + "볼");
        else if (strikeCount == 0) System.out.println("낫싱");
        else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
}

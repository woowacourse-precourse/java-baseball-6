package baseball;

public class OutputView {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}

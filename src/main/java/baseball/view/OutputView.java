package baseball.view;

public class OutputView {

    public static void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printStrikeHintMessage(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public static void printBallHintMessage(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    public static void printStrikeAndBallHintMessage(int strikeCount, int ballCount) {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public static void printNothingHintMessage() {
        System.out.println("낫싱");
    }
}

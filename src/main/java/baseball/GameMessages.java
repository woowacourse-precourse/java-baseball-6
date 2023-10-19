package baseball;

public class GameMessages {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printBallStrike(int ball, int strike) {
        System.out.println(ball + "볼" + " " + strike + "스트라이크");
    }

    public static void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    public static void printThreeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }
}

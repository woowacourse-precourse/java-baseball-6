package others;

public class Output {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printThreeStrike(final int strike) {
        System.out.println(strike + "스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printOnlyBall(final int ball) {
        System.out.println(ball + "볼");
    }

    public static void printOnlyStrike(final int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printBallAndStrike(final int ball, final int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

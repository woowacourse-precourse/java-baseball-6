package baseball.View;

public class OutputView {
    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printGameOver() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }

    public static void printBallAndStrike(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}

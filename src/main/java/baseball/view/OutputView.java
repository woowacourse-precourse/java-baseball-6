package baseball.view;

public class OutputView {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrike(int strike) {
        System.out.printf("%d스트라이크\n", strike);
    }
    public static void printBall(int ball) {
        System.out.printf("%d볼\n", ball);
    }
    public static void printBallWithStrike(int ball, int strike) {
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }
    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

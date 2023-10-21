package baseball.view;

public class OutputView {
    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void onlyBall(int ball) {
        System.out.println(ball + "볼");
    }

    public static void onlyStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void strikeAndBall(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void nothing() {
        System.out.println("낫싱");
    }
}

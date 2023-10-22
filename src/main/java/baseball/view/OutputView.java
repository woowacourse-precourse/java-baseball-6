package baseball.view;

public class OutputView {


    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public static void ballAndStrike(int ball, int strike) {
        String result = String.format("%s볼 %s스트라이크", ball, strike);
        System.out.println(result);
    }

    public static void onlyBall(int ball) {
        String result = String.format("%s볼", ball);
        System.out.println(result);
    }

    public static void onlyStrike(int strike) {
        String result = String.format("%s스트라이크", strike);
        System.out.println(result);
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void endGame() {
        String result = String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", 3);
        System.out.println(result);
    }
}

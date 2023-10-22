package baseball;

public class Information {

    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static void printInputNumber() {
        System.out.println(INPUT_NUMBER);
    }

    public static void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
    }
}

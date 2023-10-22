package baseball;

public class Information {

    public static final int MAX_DIGIT = 3;
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GUESS_ALL = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String END_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static void printInputNumber() {
        System.out.println(INPUT_NUMBER);
    }

    public static void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if (ball != 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
    }

    public static void printGuessAll() {
        System.out.println(MAX_DIGIT + GUESS_ALL);
    }

    public static void printEndGame() {
        System.out.println(END_GAME);
    }
}

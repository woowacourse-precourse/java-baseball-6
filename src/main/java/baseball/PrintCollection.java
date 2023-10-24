package baseball;

public class PrintCollection {
    public static final String NOT_3WORDS = "입력된 수가 3자리가 아닙니다.";

    public static final String NOT_INPUT_NUMBER = "숫자가 아닌 문자가 입력되었습니다.";

    public static final String NOT_INPUT_DIFFERENT_NUMBER = "입력이 서로 다른 숫자로 이루어지지 않았습니다.";

    public static final String RESTART_NUMBER_ERROR = "재시작 숫자를 잘못 입력하셨습니다.";

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRestartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printStrikes(int strikes) {
        System.out.println(strikes + "스트라이크");
    }

    public static void printBalls(int balls) {
        System.out.println(balls + "볼");
    }

    public static void printStrikesAndBalls(int strikes, int balls) {
        System.out.println(balls + "볼 " + strikes + "스트라이크");
    }
}

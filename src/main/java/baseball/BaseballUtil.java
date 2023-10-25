package baseball;

public class BaseballUtil {

    public static final int MAX = 3;
    public static final String REGEX_NUMBER = "[1-9]{3}";
    public static final String[][] STRIKE_BALL = {
            {"낫싱", "1볼", "2볼", "3볼"},
            {"1스트라이크", "1볼 1스트라이크", "1볼 2스트라이크", ""},
            {"2스트라이크", "1볼 2스트라이크", "", ""},
            {"3스트라이크", "", "", ""}
    };
    public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String RESTART = "1";
    public static final String END = "2";

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStrikeBallResult(int strike, int ball) {
        System.out.println(STRIKE_BALL[strike][ball]);
    }

    public static void printEndGame() {
        System.out.println(END_GAME);
    }

    public static void printRestartGame() {
        System.out.println(RESTART_GAME);
    }
}

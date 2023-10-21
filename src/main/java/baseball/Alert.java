package baseball;

public class Alert {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_START = "숫자를 입력 해주세요 : ";
    public static final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    public static void gameStartMessage() {
        System.out.println(GAME_START);
    }

    public static void userInputStartMessage() {
        System.out.print(INPUT_START);
    }

    public static void gameFinishMessage() {
        System.out.println(GAME_FINISH);
        System.out.println(RESTART);
    }

    public static void NothingMessage() {
        System.out.println(NOTHING);
    }

}


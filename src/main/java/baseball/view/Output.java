package baseball.view;

public class Output {
    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String INIT_NUMS = "숫자를 입력해주세요 : ";
    private static final String CHECK_NEW_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_GAME = "게임 종료";

    public static void startGame() {
        System.out.println(START);
    }

    public static void initNums() {
        System.out.print(INIT_NUMS);
    }

    public static void checkNewGame() {
        System.out.println(CHECK_NEW_GAME);
    }

    public static void battleResult(String result) {
        System.out.println(result);

    }

    public static void endGame() {
        System.out.println(END_GAME);
    }
}

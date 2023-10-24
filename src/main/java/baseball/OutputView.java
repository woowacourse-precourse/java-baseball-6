package baseball;

public class OutputView{
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String END_TEXT = "숫자 야구 게임을 종료합니다.";
    private static final String GAME_OVER_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_TEXT = "낫싱";
    private static final String BALL_STRIKE_TEXT = "%d볼 %d스트라이크\n";
    private static final String STRIKE_TEXT = "%d스트라이크\n";
    private static final String BALL_TEXT = "%d볼\n";
    private static final String NUMBER_INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartText() {
        System.out.println(START_TEXT);
    }

    public static void printEndText() {
        System.out.println(END_TEXT);
    }

    public static void printGameOverText() {
        System.out.println(GAME_OVER_TEXT);
    }

    public static void printCountText(int ballCount, int strikeCount){
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING_TEXT);
            return;
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.printf(BALL_STRIKE_TEXT, ballCount, strikeCount);
            return;
        }
        if (ballCount == 0) {
            System.out.printf(STRIKE_TEXT, strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf(BALL_TEXT, ballCount);
            return;
        }
    }

    public static void printNumberInputText() {
        System.out.print(NUMBER_INPUT_TEXT);
    }

    public static void printRestartInputText() {
        System.out.println(RESTART_INPUT_TEXT);
    }
}
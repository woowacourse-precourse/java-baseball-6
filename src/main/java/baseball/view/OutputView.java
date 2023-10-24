package baseball.view;

public class OutputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String RESTART_CHECK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String ALL_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void inputNumberMessage() {
        System.out.print(INPUT_NUMBER);
    }

    public static void restartCheckMessage() {
        System.out.println(RESTART_CHECK);
    }

    public static void startGameMesssage() {
        System.out.println(START_GAME);
    }

    public static void allStrikeMessage() {
        System.out.println(ALL_STRIKE);
    }

}

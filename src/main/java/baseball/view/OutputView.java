package baseball.view;

public class OutputView {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MSG = "게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    public static void printStartMsg() {
        System.out.println(START_MSG);
    }

    public static void printBallAndStrikeMsg(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void printBallMsg(int ball) {
        System.out.println(ball + "볼");
    }

    public static void printStrikeMsg(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printNothingMsg() {
        System.out.println("낫싱");
    }

    public static void printSuccessMsg() {
        System.out.println(SUCCESS_MSG);
    }

    public static void printRestartOrExitMsg() {
        System.out.println(RESTART_OR_EXIT_MSG);
    }

    public static void printInputMsg() {
        System.out.print(INPUT_MSG);
    }
}

package baseball.io;

public class Output {
    private Output() {
    }

    private static final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String SUCCESS_AND_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static void greetingOutput() {
        System.out.print(GREETING_MESSAGE);
    }

    public static void successAndExitOutput() {
        System.out.print(SUCCESS_AND_EXIT_MESSAGE);
    }

    public static void gameResultOutput(Object o) {
        System.out.println(o.toString());
    }
}

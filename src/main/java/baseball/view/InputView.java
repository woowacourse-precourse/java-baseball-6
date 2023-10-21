package baseball.view;

public class InputView {
    private static final String ENTER_GUESS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENTER_WHETHER_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printEnterGuess() {
        System.out.print(ENTER_GUESS_MESSAGE);
    }

    public static void printEnterRestartOrNot() {
        System.out.println(ENTER_WHETHER_RESTART);
    }
}

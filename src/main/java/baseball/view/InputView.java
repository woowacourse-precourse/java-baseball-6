package baseball.View;

public class InputView {
    private static final String ENTER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENTER_WHETHER_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void printEnterNumbers() {
        System.out.print(ENTER_NUMBERS_MESSAGE);
    }

    public static void printEnterWhetherRestart() {
        System.out.println(ENTER_WHETHER_RESTART);
    }
}

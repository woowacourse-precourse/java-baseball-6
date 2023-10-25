package baseball.view;

public class InputView {
    private static final String InputPlayerNumbers = "숫자를 입력해주세요 : ";
    private static final String InputRetryOrQuitMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printInputPlayerNumbers() {
        System.out.print(InputPlayerNumbers);
    }

    public static void printRetryMessage() {
        System.out.print(InputRetryOrQuitMessage);
    }
}

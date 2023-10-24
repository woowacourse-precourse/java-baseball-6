package baseball.view;

public class InputView {

    private InputView() {
    }

    public static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

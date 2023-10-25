package baseball.view;

public class RequestInput {
    public static void requestInputData() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printRetryMessage() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

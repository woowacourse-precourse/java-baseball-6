package baseball.view;

public class AskView {

    public static void printAskNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printAskResume(final int restart, final int end) {
        System.out.println("게임을 새로 시작하려면 " + restart + ", 종료하려면 " + end + "를 입력하세요.");
    }
}

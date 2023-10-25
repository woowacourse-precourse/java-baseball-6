package baseball;

public class SystemMessage {
    public static void printStartMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
    }

    public static void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void requestInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void requestRetryMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}

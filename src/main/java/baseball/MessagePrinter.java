package baseball;

//util class
public final class MessagePrinter {
    private MessagePrinter() {
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGetNumberMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printResultMessage(int strike, int ball) {
        System.out.println(
                (strike == 0 && ball == 0) ? "낫싱" :
                        new StringBuilder()
                                .append(ball > 0 ? ball + "볼" : "")
                                .append(strike > 0 && ball > 0 ? " " : "")
                                .append(strike > 0 ? strike + "스트라이크" : "")
                                .toString());

    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

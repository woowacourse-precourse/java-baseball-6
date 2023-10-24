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
        if (ball > 0) System.out.print(ball + "볼 ");
        if (strike > 0) System.out.println(strike + "스트라이크");
        if (strike == 0 & ball == 0) System.out.println("낫싱");
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

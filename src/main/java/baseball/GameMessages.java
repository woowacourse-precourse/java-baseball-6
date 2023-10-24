package baseball;

public class GameMessages {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStatusMessage(int ball, int strike) {
        StringBuilder message = new StringBuilder();

        if (strike == 3) {
            printThreeStrikeMessage();
            return;
        }

        if (ball > 0) {
            message.append(ball).append("볼 ");
        }

        if (strike > 0) {
            message.append(strike).append("스트라이크 ");
        }

        if (message.length() == 0) {
            message.append("낫싱");
        }

        System.out.println(message.toString().trim());
    }

    private static void printThreeStrikeMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

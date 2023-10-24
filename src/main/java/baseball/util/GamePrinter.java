package baseball.util;

/**
 * 게임과 관련된 메시지를 출력하는 유틸리티 클래스입니다.
 */
public class GamePrinter {
    /**
     * 게임 시작 메시지를 출력합니다.
     */
    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 사용자 입력 메시지를 출력합니다.
     */
    public static void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    /**
     * 게임 결과 메시지를 출력합니다.
     *
     * @param ball 볼 개수
     * @param strike 스트라이크 개수
     */
    public static void resultMessage(int ball, int strike) {
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


    //3 스트라이크 메시지를 출력합니다.
    private static void printThreeStrikeMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

package baseball;

public class OutputMessage {
    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String nothingMessage = "낫싱", ballMessage = "볼", strikeMessage = "스트라이크";
    private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public static void printStartMessage() {
        System.out.println(startMessage);
    }

    public static void printInputMessage() {
        System.out.print(inputMessage);
    }

    public static void printResultMessage(int ball, int strike) {
        printBallStrikeMessage(ball, strike);
        if (strike == 3) {
            printEndMessage();
        }
    }

    private static void printBallStrikeMessage(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + ballMessage + " " + strike + strikeMessage);
        } else if (ball > 0) {
            System.out.println(ball + ballMessage);
        } else if (strike > 0) {
            System.out.println(strike + strikeMessage);
        } else {
            System.out.println(nothingMessage);
        }
    }

    public static void printEndMessage() {
        System.out.println(endMessage);
    }

    public static void restartMessage() {
        System.out.println(restartMessage);
    }
}

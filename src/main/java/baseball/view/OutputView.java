package baseball.view;

public class OutputView {

    public static final String gameStartMessage = "숫자 야구 게임을 시작합니다.";
    public static final String matchAllNumberMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ballMessage = "볼 ";
    public static final String strikeMessage = "스트라이크 ";
    public static final String nothingMessage = "낫싱";

    public static void printGameStartMessage() {
        System.out.println(gameStartMessage);
    }

    public static void printMatchAllNumberMessage() {
        System.out.println(matchAllNumberMessage);
    }

    public static void printResultMessage(int strike, int ball) {
        if (ball != 0) {
            System.out.print(ball + ballMessage);
        }
        if (strike != 0) {
            System.out.print(strike + strikeMessage);
        }
        if (ball == 0 && strike == 0) {
            System.out.print(nothingMessage);
        }
        System.out.println();
    }
}

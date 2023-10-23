package baseball;

public class Output {

    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String gameRestartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public void printResult(int ball, int strike, int nothing) {
        if (nothing > 0) {
            System.out.println(NOTHING);
        }
        else if (ball > 0 && strike > 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        else if (ball > 0) {
            System.out.println(ball + BALL);
        }
        else if (strike > 0) {
            System.out.println(strike + STRIKE);
        }
    }

    public void printStartMessage() {
        System.out.println(startMessage);
    }

    public void printInputMessage() {
        System.out.print(inputMessage);
    }

    public void printGameEndMessage() {
        System.out.println(gameEndMessage);
    }

    public void printGameRestartMessage() {
        System.out.println(gameRestartMessage);
    }
}

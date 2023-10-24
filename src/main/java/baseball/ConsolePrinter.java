package baseball;

public class ConsolePrinter {
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final String STRING_BALL = "볼";
    private static final String STRING_STRIKE = "스트라이크";
    private static final String STRING_NOTHING = "낫싱";
    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String OUTPUT_START = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OUTPUT_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public void startPrint() {
        System.out.println(OUTPUT_START);
    }

    public void pleaseEnterNumber() {
        System.out.print(OUTPUT_ENTER_NUMBER);
    }

    public void successPrint() {
        System.out.println(OUTPUT_SUCCESS);
    }

    public void restartPrint() {
        System.out.println(OUTPUT_RESTART_OR_QUIT);
    }

    public void printResult(int[] result) {
        int ball = result[BALL];
        int strike = result[STRIKE];
        if (ball == 0 && strike == 0) {
            System.out.println(STRING_NOTHING);
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + STRING_STRIKE);

        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + STRING_BALL);

        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + STRING_BALL + " " + strike + STRING_STRIKE);
        }
    }
}

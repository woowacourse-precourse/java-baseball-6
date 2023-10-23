package baseball.view;

public class OutputView {
    public static final String START_MESSAGE =  "숫자 야구 게임을 시작합니다. ";

    public static final String INPUT_NUMBER_MESSAGE =  "숫자를 입력해주세요 : ";

    public static final String BALL = "볼 ";

    public static final String STRIKE = "스트라이크 ";

    public static final  String NOTHING = "낫싱";

    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String END = "게임종료";

    public static final String NEW_LINE ="\n";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printScore(int ball, int strike) {
        System.out.print(messageBuilder(ball, BALL));
        System.out.print(messageBuilder(strike, STRIKE));
        if (ball + strike == 0) {
            System.out.print(NOTHING);
        }
        System.out.print(NEW_LINE);
    }


    public static void printGameEnd() {
        System.out.println(GAME_END);
        System.out.println(END_OR_RESTART);
    }
    public static void printEnd() {
        System.out.println(END);
    }

    private static StringBuilder messageBuilder(int number, String ballType) {
        StringBuilder sb = new StringBuilder();
        if (number != 0) {
            return sb.append(number).append(ballType);
        }
        return sb;
    }


}

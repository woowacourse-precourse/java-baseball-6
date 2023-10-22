package baseball;

public class Printer {
    private static final String START_GAME_COMMENT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_COMMENT = "숫자를 입력해주세요 : ";
    private static final String END_GAME_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartGameComment() {
        System.out.println(START_GAME_COMMENT);
    }

    public static void printInputNumberComment() {
        System.out.print(INPUT_NUMBER_COMMENT);
    }

    public static void printEndGameComment() {
        System.out.println(END_GAME_COMMENT);
    }

    public static void printRestartGameComment() {
        System.out.println(RESTART_GAME_COMMENT);
    }

    public static void printRoundResult(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
}

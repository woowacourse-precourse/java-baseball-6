package baseball.view;

public class View {

    private static final String START_OF_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String END_OF_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OF_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTING = "낫싱";

    public static void start() {
        System.out.println(START_OF_GAME);
    }

    public static void end() {
        System.out.println(END_OF_GAME);
    }

    public static void restart() {
        System.out.println(RESTART_OF_GAME);
    }

    public static void input() {
        System.out.print(INPUT_NUMBERS);
    }

    public static void result(final int strike, final int ball) {
        StringBuilder sb = new StringBuilder();

        if (strike == 0 && ball == 0) {
            sb.append(NOTING);
        }
        if (ball != 0) {
            sb.append(ball).append(BALL).append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append(STRIKE);
        }

        System.out.println(sb);
    }
}

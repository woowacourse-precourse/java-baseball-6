package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String STRIKE_BALL_OUTPUT = "%d볼 %d스트라이크";

    private static final String ONLY_STRIKE = "%d스트라이크";
    private static final String ONLY_BALL = "%d볼";
    private static final String NOTHING = "낫싱";


    private static OutputView instance = new OutputView();


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }


    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputInitMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public void strikeBall(int strike, int ball) {
        System.out.println(String.format(STRIKE_BALL_OUTPUT, ball, strike));
    }

    public void endGame() {
        System.out.println(END_GAME);
    }

    public void onlyStrike(int strike) {
        System.out.println(String.format(ONLY_STRIKE, strike));
    }

    public void restart() {
        System.out.println(RESTART);
    }

    public void onlyBall(int ball) {
        System.out.println(String.format(ONLY_BALL, ball));
    }

    public void nothing() {
        System.out.println(NOTHING);
    }
}

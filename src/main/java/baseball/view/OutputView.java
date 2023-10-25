package baseball.view;

public class OutputView {

    private final static String REQUEST_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String BALL = "볼 ";
    private final static String STRIKE = "스트라이크";
    private final static String NOTHING = "낫싱";
    private final static String GAME_OVER_MESSAGE = "게임을 종료합니다.";
    private final static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printRequestInputNumberMessage() {
        System.out.print(REQUEST_INPUT_NUMBER_MESSAGE);
    }

    public void printBall(int ballCount) {
        System.out.print(ballCount + BALL);
    }

    public void printStrike(int strikeCount) {
        System.out.print(strikeCount + STRIKE);
    }

    public void printNothing() {
        System.out.print(NOTHING);
    }

    public void printGameClear() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }

}

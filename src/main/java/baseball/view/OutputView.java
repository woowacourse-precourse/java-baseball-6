package baseball.view;

public class OutputView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public void startMessage() {
        System.out.println(START_GAME);
    }

    public void inputNumberMessage() {
        System.out.print(INPUT_NUMBER);
    }

    public void gameSuccessMessage() {
        System.out.println(SUCCESS);
    }

    public void contiOrEndMessage() {
        System.out.println(CONTINUE_OR_END);
    }

    public void printResult(int ball, int strike, boolean isNothing) {
        if (isNothing) {
            System.out.println(NOTHING);
            return;
        }
        String hint = "";
        if (ball > 0) {
            hint += ball + BALL;
        }
        if (strike > 0) {
            hint += strike + STRIKE;
        }
        System.out.println(hint);
    }
}

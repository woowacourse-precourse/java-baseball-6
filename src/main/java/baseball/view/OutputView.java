package baseball.view;

import java.util.List;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACE = " ";
    private static final String MATHCES_ALL_NUMBERS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final int BALL_INDEX_IN_LIST = 0;
    private static final int STRIKE_INDEX_IN_LIST = 1;
    private static final int ZERO = 0;

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printCompareResult(List<Integer> ballStrike) {
        int ball = ballStrike.get(BALL_INDEX_IN_LIST);
        int strike = ballStrike.get(STRIKE_INDEX_IN_LIST);

        if (ball == ZERO && strike == ZERO) {
            System.out.print(NOTHING_MESSAGE);
        }
        if (ball > ZERO) {
            System.out.print(ball + BALL_MESSAGE + SPACE);
        }
        if (strike > ZERO) {
            System.out.print(strike + STRIKE_MESSAGE);
        }
        System.out.println();
    }

    public void printFinishMessage() {
        System.out.println(MATHCES_ALL_NUMBERS);
    }
}

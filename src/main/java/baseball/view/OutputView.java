package baseball.view;

import baseball.domain.Balls;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";
    private static final int ZERO = 0;

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRoundResult(Balls computer, Balls user) {
        int numberOfStrike = computer.countStrike(user);
        int numberOfBall = computer.countBall(user);

        if (computer.isNothing(user)) {
            System.out.println(NOTHING);
            return;
        }

        if (numberOfBall != ZERO && numberOfStrike != ZERO) {
            System.out.println(numberOfBall + BALL + SPACE + numberOfStrike + STRIKE);
            return;
        }

        if (numberOfBall != ZERO) {
            System.out.println(numberOfBall + BALL);
        }

        if (numberOfStrike != ZERO) {
            System.out.println(numberOfStrike + STRIKE);
        }
    }
}

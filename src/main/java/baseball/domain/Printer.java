package baseball.domain;

class Printer {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ONLY_STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    private static final String ONLY_BALL_MESSAGE_FORMAT = "%d볼";
    private static final String STRIKE_BALL_MESSAGE_FORMAT = "%d볼 %d스트라이크";

    Printer() {
    }

    void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    void printResult(StrikeBallCount strikeBallCount) {
        int strikeCount = strikeBallCount.strike();
        int ballCount = strikeBallCount.ball();
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        if (ballCount == 0) {
            System.out.printf((ONLY_STRIKE_MESSAGE_FORMAT) + "%n", strikeCount);
            return;
        }

        if (strikeCount == 0) {
            System.out.printf((ONLY_BALL_MESSAGE_FORMAT) + "%n", ballCount);
            return;
        }

        System.out.printf((STRIKE_BALL_MESSAGE_FORMAT) + "%n", strikeCount, ballCount);
    }

    void printEndMessage() {
        System.out.println();
    }
}

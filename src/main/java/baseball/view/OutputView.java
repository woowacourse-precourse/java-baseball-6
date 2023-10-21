package baseball.view;

import baseball.domain.Round;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_CORRECT_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printRoundResult(Round round) {
        StringBuilder sb = new StringBuilder();
        if (round.hasBall()) {
            sb.append(round.getBallCount()).append(BALL_MESSAGE);
        }
        if (round.hasStrike()) {
            sb.append(round.getStrikeCount()).append(STRIKE_MESSAGE);
        }
        if (sb.isEmpty()) {
            sb.append(NOTHING_CORRECT_MESSAGE);
        }
        System.out.println(sb);
    }
}

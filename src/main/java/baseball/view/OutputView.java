package baseball.view;

import baseball.domain.RoundResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크 ";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void print(RoundResult roundResult) {
        StringBuilder sb = new StringBuilder();
        if (roundResult.isNothing()) {
            sb.append(NOTHING);
        }
        if (roundResult.getBallCount() > 0) {
            sb.append(roundResult.getBallCount() + BALL);
        }
        if (roundResult.getStrikeCount() > 0) {
            sb.append(roundResult.getStrikeCount() + STRIKE);
        }
        if (roundResult.isGameEnd()) {
            sb.append(GAME_END_MESSAGE);
        }
        System.out.println(sb);
    }
}

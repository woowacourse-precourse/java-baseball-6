package baseball.view;

import baseball.domain.GameStatus;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRoundResult(GameStatus gameStatus) {
        StringBuilder sb = new StringBuilder();
        int ballCount = gameStatus.getBallCount();
        int strikeCount = gameStatus.getStrikeCount();
        if (ballCount != 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (sb.isEmpty()) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }
}

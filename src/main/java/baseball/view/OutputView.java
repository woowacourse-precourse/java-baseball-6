package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRoundResult(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCount();
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

    public void printSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

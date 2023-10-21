package baseball.handler;

import baseball.GameResult;

public class OutputHandler {
    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String WHITE_SPACE = " ";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printFinishMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public void printGameResult(GameResult result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if(ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount != 0) {
            stringBuilder.append(ballCount).append(BALL).append(WHITE_SPACE);
        }
        if(strikeCount != 0) {
            stringBuilder.append(strikeCount).append(STRIKE);
        }
        System.out.println(stringBuilder);
    }
}

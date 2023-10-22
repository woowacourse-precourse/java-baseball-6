package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printHint(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if(ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return;
        }

        if(ballCount > 0) {
            sb.append(ballCount).append(BALL);
            sb.append(" ");
        }

        if(strikeCount > 0) {
            sb.append(strikeCount).append(STRIKE);
        }

        System.out.println(sb);
    }
}

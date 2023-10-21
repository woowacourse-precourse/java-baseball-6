package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printHint(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if(ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }

        if(ballCount > 0) {
            sb.append(ballCount).append("볼");
            sb.append(" ");
        }

        if(strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        System.out.println(sb);
    }
}

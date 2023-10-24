package baseball.game;

public class Message {
    public final String start = "숫자 야구 게임을 시작합니다.";
    public final String requestCommand = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final String requestNumber = "숫자를 입력해 주세요 : ";
    public final String end = "게임 종료";
    private final String strike = "스트라이크";
    private final String ball = "볼";
    private final String nothing = "낫싱";

    // 볼-스트라이크 메시지 생성
    public String makeMessage(int[] ballCount) {
        StringBuilder message = new StringBuilder();

        // nothing
        if (ballCount[0] == 0 && ballCount[1] == 0) {
            return message.append(nothing).toString();
        }

        // ball
        if (ballCount[0] != 0) {
            message.append(ballCount[0]).append(ball).append(' ');
        }

        // strike
        if (ballCount[1] != 0) {
            message.append(ballCount[1]).append(strike);
        }

        return message.toString();
    }
}
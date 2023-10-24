package baseball.message;

public final class ConsoleMessage {
    public final static String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public final static String PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String reportMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        String strikeMessage = "", ballMessage = "";

        if (strike != 0) {
            strikeMessage = strike + "스트라이크";
        }

        if (ball != 0) {
            ballMessage = ball + "볼";
        }

        return ballMessage + " " + strikeMessage;
    }

}

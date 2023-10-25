package baseball;

public class MessageList {

    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String INPUT = "숫자를 입력해주세요 : ";
    static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String ALL_CORRECT = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    static final String NOTHING = "낫싱";
    static final String BALL = "볼 ";
    static final String STRIKE = "스트라이크";
    static final String NO_COUNT = "";

    static final String CONTINUE = "1";
    static final String GAME_END = "3스트라이크";


    public static String setStrikeMessage(int strikes) {
        String strikeMessage = strikes + STRIKE;
        if (strikes == 0) {
            strikeMessage = NO_COUNT;
        }
        return strikeMessage;
    }

    public static String setBallMessage(int balls) {
        String ballComment = balls + BALL;
        if (balls == 0) {
            ballComment = NO_COUNT;
        }
        return ballComment;
    }
}

package baseball.global;

import baseball.Game;

public class Announcement {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String IN_GAME = "숫자를 입력하세요 : ";
    public static final String GAME_WIN = Game.INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_TERMINATE = 
            "게임을 새로 시작하려면 " + Game.GAME_AGAIN_CODE + ", 종료하려면 " + Game.GAME_TERMINATE_CODE + "를 입력하세요.";
    
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static String ballAndStrike(int ball, int strike) {
        return ball + BALL + " " + strike + STRIKE;
    }
    public static String ball(int ball) {
        return ball + BALL;
    }
    public static String strike(int strike) {
        return strike + STRIKE;
    }
    public static String nothing() {
        return NOTHING;
    }
}

package baseball.string;

public final class MyConstants {
    private MyConstants() {
    }

    // 전체 클래스
    public static String RESET_STRING() {
        return "";
    }

    // Judge.class

    public static String MSG_NOT_THING() {
        return "낫싱";
    }

    public static String MSG_ONLY_STRIKE(int cntStrike) {
        return cntStrike + "스트라이크";
    }

    public static String MSG_ONLY_BALL(int cntBall) {
        return cntBall + "볼";
    }

    public static String MSG_BALL_STRIKE(int cntBall, int cntStrike) {
        return cntBall + "볼 " + cntStrike + "스트라이크";
    }

    // Application.class
    public static String MSG_GAME_TERMINATION_CONDITION_STR() {
        return "3스트라이크";
    }

    public static String MSG_INPUT_NUMBER_STR() {
        return "숫자를 입력해주세요 : ";
    }

    public static String MSG_END_GAME_COMMENT_STR() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String MSG_GAME_PROGRESS_SELECTION_STATUS_STR() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}

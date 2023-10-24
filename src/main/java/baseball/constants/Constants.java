package baseball.constants;

public final class Constants {
    //예외 상황
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 잘못된 숫자를 입력하셨습니다. ";
    public static final String ERROR_INVALID_COMMAND = "[ERROR] 잘못된 커멘드 명령어를 입력하셨습니다.";

    //game 숫자 제어용
    public static final int NUMBER_SIZE = 3;
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 9;

    // 게임 입출력 문자열들
    public static final String GAME_START_STRING = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_NUMBER_INPUT_STRING = "숫자를 입력해주세요 : ";
    public static final String GAME_END_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_INPUT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_SCORE_NOTHING = "낫싱";
    public static final String GAME_SCORE_BALL = "%d볼 ";
    public static final String GAME_SCORE_STRIKE = "%d스트라이크";
}

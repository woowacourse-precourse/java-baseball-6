package baseball.constant;

public enum TextConstant {

    TextConstant() {
    };

    public static final String INIT_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String WIN_THE_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEXT_GAME_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GUESS_NUMBER_LENGTH_EXCEPTION = "3자리 수를 입력해주세요.";
    public static final String GUESS_NUMBER_DUPLICATION = "중복된 수를 입력할 수 없습니다.";
    public static final String NEXT_GAME_STATE_EXCEPTION = "재시작/종료를 하려면 1과 2 중 하나의 수를 입력해주세요.";

    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크 ";
    public static final String NOTHING = "낫싱";
    public static final String SPLIT_UNIT = "";
}

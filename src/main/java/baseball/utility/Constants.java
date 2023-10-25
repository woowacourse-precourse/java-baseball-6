package baseball.utility;

public final class Constants { //상속을 막기 위해 final 사용
    private Constants(){} //생성자를 private로 지정하여 인스턴스 생성 막기

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_PROMPT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String BALL= "볼";
    public static final String STRIKE= "스트라이크";
    public static final String NOTHING= "낫싱";
    public static final String NUMBER_CORRECT_MESSAGE= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_PAUSE_OR_RESUME_PROMPT_MESSAGE= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final int NUMBER_LIMIT_LENGTH = 3;

    //정규표현식 패턴
    public static final String VALID_NUMBER_PATTERN = "^(?!.*(\\d).*\\1)[1-9]{3}$";
}

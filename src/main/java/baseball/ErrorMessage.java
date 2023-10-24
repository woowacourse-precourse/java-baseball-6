package baseball;

public class ErrorMessage {
    public static final String INCLUSION_STRING_ERROR = "숫자를 입력해 주세요. 게임을 종료합니다.";
    public static final String DUPLICATE_NUMBER_ERROR = "각자 다른 세 자리 수를 입력해주세요. 게임을 종료합니다.";
    public static final String INCLUSION_ZERO_ERROR = "1~9까지의 숫자만 입력해주세요. 게임을 종료합니다.";
    public static final String LENGTH_ERROR = "3자리의 서로 다른 숫자를 입력해주세요. 게임을 종료합니다.";
    public static final String CHOICE_NUMBER_ERROR =
            GameRuleNumbers.GAME_RESTART + " 혹은 " + GameRuleNumbers.GAME_END + "를 입력해주세요. 게임을 종료합니다.";
}

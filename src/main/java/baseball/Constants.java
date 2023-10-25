package baseball;

public class Constants {
	public static final int NUMBER_LENGTH = 3;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;
	public static final String RETRY_TRUE = "1";
	public static final String RETRY_FALSE = "2";

	public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	public static final String GUESS_MESSAGE = "숫자를 입력해주세요: ";
	public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String INVALID_LENGTH_ERROR = "[ERROR] " + NUMBER_LENGTH + "자리 수를 입력해주세요";
	public static final String DUPLICATE_DIGITS_ERROR = "[ERROR] 서로 다른 " + NUMBER_LENGTH + "자리 숫자를 입력해주세요";
	public static final String INVALID_RETRY_INPUT_ERROR = "[ERROR] 1 혹은 2로 입력해주세요";
}

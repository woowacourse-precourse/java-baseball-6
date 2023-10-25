package baseball.domain.Validator;

import java.util.HashSet;


public class PlayerInputValidator {
    public static final String NOT_VALID_INPUT_SIZE_ERROR_MESSAGE = "3자리의 숫자만 입력해주세요.";
    public static final String NOT_VALID_NUMBER_RANGE_ERROR_MESSAGE = "1부터 9사이의 숫자만 입력해주세요.";
    public static final String NOT_VALID_DUPLICATE_NUMBER_ERROR_MESSAGE = "입력 숫자는 중복을 허용하지 않습니다.";
    public static final String NOT_VALID_RESTART_NUMBER_ERROR_MESSAGE = "재시작을 원할경우 1, 종료를 원할경우 2를 입력해주세요.";
    public static final String GAME_RESTART_CODE = "1";
    public static final String GAME_END_CODE = "2";
    public static final char START_BALL_CHARACTER = '1';
    public static final char END_BALL_CHARACTER = '9';
    public static final int MAX_BALL_SIZE = 3;


    public void validAnswerNumber(String playerInput) {
        if (playerInput.length() != MAX_BALL_SIZE) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_SIZE_ERROR_MESSAGE);
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < playerInput.length(); i++) {
            if (!(playerInput.charAt(i) >= START_BALL_CHARACTER && playerInput.charAt(i) <= END_BALL_CHARACTER)) {
                throw new IllegalArgumentException(NOT_VALID_NUMBER_RANGE_ERROR_MESSAGE);
            }
            if (!set.add(playerInput.charAt(i))) {
                throw new IllegalArgumentException(NOT_VALID_DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public void validRestartNumber(String playerInput) {
        if (!(playerInput.equals(GAME_RESTART_CODE) || playerInput.equals(GAME_END_CODE))) {
            throw new IllegalArgumentException(NOT_VALID_RESTART_NUMBER_ERROR_MESSAGE);
        }
    }
}

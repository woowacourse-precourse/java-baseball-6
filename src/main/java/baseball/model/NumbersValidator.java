package baseball.model;

import java.util.List;

public class NumbersValidator {
    private static final String INPUT_LENGTH_IS_NOT_VALID = "입력한 값의 길이가 3이 아닙니다.";
    private static final String INPUT_IS_NOT_CONSIST_OF_NUMBERS = "입력한 값에 숫자가 아닌 값이 포함되어 있습니다.";
    private static final String INPUT_NUMBER_IS_NOT_IN_RANGE = "입력한 값을 이루고 있는 숫자가 범위를 벗어났습니다.";
    private static final String INPUT_HAS_DUPLICATED_NUMBER = "입력한 값에 중복된 숫자가 포함되어 있습니다.";
    private static final int VALID_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private String playerNumber;
    private List<Integer> playerNum;

}

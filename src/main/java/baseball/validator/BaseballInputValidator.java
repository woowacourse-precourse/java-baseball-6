package baseball.validator;

import static baseball.model.BaseballGameModel.BASEBALL_NUMBER_SIZE;

public class BaseballInputValidator {

    public static final String ZERO = "0";
    public static final String MENU_REPLAY = "1";
    public static final String MENU_EXIT = "2";

    public static void validateBaseballNumbers(String inputNums) {
        // 5. 사용자가 3개의 숫자만 입력해야 하는데 4개의 수를 입력했을 때
        if (inputNums.length() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        // 6. 사용자가 1~9사이의 숫자만 입력하지 않고, 0을 입력했을 때
        if (inputNums.contains(ZERO)) {
            throw new IllegalArgumentException("1~9사이의 숫자를 입력해야 합니다.");
        }
    }

    // 7. 사용자가 게임 재시작 또는 게임 종료를 선택할 때 1이나 2이외의 숫자를 입력했을 때
    public static void validateMenuNumber(String inputNum) {
        if (!(inputNum.equals(MENU_REPLAY)) && !(inputNum.equals(MENU_EXIT))) {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }
    }
}

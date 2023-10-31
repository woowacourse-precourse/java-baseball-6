package racingcar.exception;

public enum ErrorMsg {

    ERROR_CAR_NOT_FOUND_NAME("[ERROR] 자동차 이름을 입력해주세요."),
    ERROR_CAR_NAME_LENGTH_MORE_THAN_6("[ERROR] 자동차 이름을 6글자 미만으로 입력해주세요."),
    ERROR_CAR_NAME_SAME("[ERROR] 자동차 이름이 중복 되었습니다."),
    ERROR_GAME_CYCLE_SAME_0("[ERROR] 시도할 횟수를 1 이상으로 입력해주세요."),
    ERROR_INPUT_NOT_NUMBER("[ERROR] 시도할 횟수는 숫자로 입력 해주세요."),
    ERROR_CAR_NAME_MIN_LENGTH("[ERROR] 자동차 이름 길이를 두글자 이상 입력해주세요."),
    ERROR_CAR_NAME_BLANK_BAR("[ERROR] 자동차 이름에 공백이 들어가 있습니다."),
    ERROR_CAR_LAST_WORD("자동차 이름이 쉼표로 끝날 수 없습니다.");

    private String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}



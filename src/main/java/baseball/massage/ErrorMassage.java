package baseball.massage;

public enum ErrorMassage {
    NOT_THREE_DIGIT("3자리의 숫자가 필요합니다."),
    NOT_ONLY_NUMBER("숫자로만 이루어진 3자리가 필요합니다."),
    NOT_DUPLICATE_NUMBER("각 자리 숫자가 중복되지 않는 3자리 숫자가 필요합니다."),
    ONLY_ONE_OR_TWO("1과 2 둘 중 하나만 입력해주세요.");

    private final String errorMessage;

    ErrorMassage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}

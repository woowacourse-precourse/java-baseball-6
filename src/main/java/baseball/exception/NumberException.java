package baseball.exception;

public enum NumberException {

    NUMBER_COUNT_EXCEPTION("숫자 개수가 부정확합니다"),
    NUMBER_RANGE_EXCEPTION("숫자 범위가 부정확합니다"),
    NUMBER_DUP_EXCEPTION("숫자가 중복됩니다");

    private String errorMsg;

    NumberException(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg(){ return errorMsg; }
}

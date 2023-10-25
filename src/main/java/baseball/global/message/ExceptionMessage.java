package baseball.global.message;

public enum ExceptionMessage {

    INPUT_NOT_NUMERIC("숫자 이외에는 입력할 수 없습니다."),
    INPUT_SIZE_MISMATCH("입력한 숫자의 자릿수가 일치하지 않습니다."),
    INPUT_NOT_DISTINCT("숫자를 중복하여 입력할 수 없습니다."),
    INPUT_UNDEFINED("정의되지 않은 입력값입니다."),
    INPUT_ZERO_UNAVAILABLE("0은 입력할 수 없습니다.");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}

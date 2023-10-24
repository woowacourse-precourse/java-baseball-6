package baseball.exception;

public enum NumExceptionEnum {

    WRONG_SIZE_NUM("잘못된 자릿수의 숫자를 입력"),
    NOT_INTEGER("정수가 아닌 값을 입력");


    public String msg;

    NumExceptionEnum(String msg) {
        this.msg = msg;
    }




}

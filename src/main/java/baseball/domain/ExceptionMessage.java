package baseball.domain;

public final class ExceptionMessage {

    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
    public static final String BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE = "야구 숫자 목륵은 3개여야 합니다.";
    public static final String BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "야구 숫자 목록은 중복되지 않아야 합니다.";
    public static final String RESTART_EXCEPTION_MESSAGE = "게임 재시작 번호가 잘못되었습니다.";

    private ExceptionMessage() {
    }

}

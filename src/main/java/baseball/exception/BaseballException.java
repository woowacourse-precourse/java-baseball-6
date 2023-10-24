package baseball.exception;

public class BaseballException {

    public static class ListSizeException extends IllegalArgumentException {
        public ListSizeException() {
            super("서로 다른 3개의 숫자를 입력해주세요");
        }
    }

    public static class NumberException extends IllegalArgumentException {
        public NumberException() {
            super("숫자를 입력해주세요");
        }
    }

    public static class NumberRangeException extends IllegalArgumentException {
        public NumberRangeException() {
            super("1~9 사이의 숫자를 입력해주세요");
        }
    }

}

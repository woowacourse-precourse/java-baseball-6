package baseball.Utils;

public class ExceptionProcess {
    // 사용자 입력 예외처리

    // 1. 숫자가 아닌 문자를 입력한 경우
    public static void nonNumericInputException() {
        throw new IllegalArgumentException("숫자를 입력해 주세요.");
    }

    // 2. 숫자를 3개 초과로 입력한 경우
    public static void inputLengthExceededException() {
        throw new IllegalArgumentException("숫자는 3개만 입력해 주세요.");
    }

    // 3. 중복이 존재하는 경우
    public static void duplicateNumberException() {
        throw new IllegalArgumentException("숫자 중복은 허용되지 않습니다.");
    }

    // 4. 1 ~ 9에 해당하지 않는 수가 있는 경우
    public static void invalidNumberException() {
        throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해 주세요. ");
    }


    // 재시작/종료 여부를 입력할 때

    // 1. 숫자가 아닌 문자를 입력한 경우
    // 사용자 1번 예외처리와 동일

    // 2. 1 or 2를 제외한 수를 입력한 경우

    // 3. 입력을 하지 않은 경우
    public static void missingInputException() {
        throw new IllegalArgumentException("입력을 해주세요");
    }
}

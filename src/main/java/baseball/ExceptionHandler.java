package baseball;

public class ExceptionHandler {
    // 게임 실행 중의 입력
    public void handleInputException(String inputValue) {
        checkInputLength(inputValue);
        checkNumericInput(inputValue);
        checkDistinctNumbers(inputValue);
    }

    // 오직 숫자만
    private void checkNumericInput(String inputValue) {
        char[] values = inputValue.toCharArray();
        // 숫자
        for (char value : values) {
            if (!Character.isDigit(value)) {
                throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력 하시면 곤란합니다.");
            }
        }
    }

    // 서로 다른 숫자
    private void checkDistinctNumbers(String inputValue) {
        char[] values = inputValue.toCharArray();

        if (values[0] == values[1] || values[1] == values[2] || values[2] == values[0]) {
            throw new IllegalArgumentException("서로 다른 숫자를 선택해 주세요.");
        }
    }

    // 3자리
    private void checkInputLength(String inputValue) {
        if (inputValue.length() != 3) {
            throw new IllegalArgumentException("!3개!의 숫자를 선택해 주세요.");
        }
    }

    // 게임 재시작 여부를 입력 받을 때
    public void handleRestartInputException(String inputValue) {
        if (!(inputValue.equals("1") || inputValue.equals("2"))) {
            throw new IllegalArgumentException("1과 2 중에 선택해 주세요.");
        }
    }
}

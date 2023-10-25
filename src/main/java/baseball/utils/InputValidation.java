package baseball.utils;

public class InputValidation {

    private static final int MAX_LENGTH = 3;

    // Player 가 입력한 임의의 3자리 수를 검증하는 메서드.
    public void validation(String inPutNumber) {
        lengthValidation(inPutNumber);
        numberValidation(inPutNumber);
//        overlapValidation(inPutNumber);
    }

    // 입력한 수가 3자리가 맞는지 검증하는 메서드.
    private void lengthValidation(String inPutNumber) {
        if (inPutNumber.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH.getCode());
        }
    }

    // 숫자만 입력했는지 검증하는 메서드.
    private void numberValidation(String inPutNumber) {
        if (!inPutNumber.matches("^[\\d]*$")) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER.getCode());
        }
    }
}

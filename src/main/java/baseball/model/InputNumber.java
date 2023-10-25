package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String INPUT_REGEX_PATTERN = "^(?!.*(\\d).*\\1)[1-9]{3}$";
    private static final String INPUT_EXCEPTION_MESSAGE_START = "1부터 9까지 서로 다른 ";
    private static final String INPUT_EXCEPTION_MESSAGE_END = "자리의 숫자를 공백, 문자 없이 연속하여 입력해주십시오.";
    private static final String RESTART_NUMBER = "1";
    private static final String QUIT_NUMBER = "2";
    private static final String QUIT_EXCEPTION_MESSAGE = "1(재시작) 또는 2(종료)를 입력해주세요.";
    private final List<Integer> inputNumber = new ArrayList<>();
    private String quitNumber = "";

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String playerInput) throws IllegalArgumentException {
        String exceptionMessage = INPUT_EXCEPTION_MESSAGE_START + NUMBER_OF_DIGITS + INPUT_EXCEPTION_MESSAGE_END;
        if (!playerInput.matches(INPUT_REGEX_PATTERN)) {
            throw new IllegalArgumentException(exceptionMessage);
        }

        for (int i = 0; i < playerInput.length(); i++) {
            char letter = playerInput.charAt(i);
            inputNumber.add(Integer.parseInt(String.valueOf(letter)));
        }
    }
    public String getQuitNumber() {
        return quitNumber;
    }

    public void setQuitNumber(String playerInput) throws IllegalArgumentException {
        if (!playerInput.equals(RESTART_NUMBER) && !playerInput.equals(QUIT_NUMBER)) {
            throw new IllegalArgumentException();
        }
        quitNumber = playerInput;
    }
}

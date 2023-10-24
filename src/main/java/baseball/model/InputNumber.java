package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String INPUT_REGEX_PATTERN = "^(?!.*(\\d).*\\1)[1-9]{3}$";
    private final List<Integer> inputNumber = new ArrayList<>();
    private String quitNumber = "";

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String playerInput) throws IllegalArgumentException {
        if (!playerInput.matches(INPUT_REGEX_PATTERN)) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 " + NUMBER_OF_DIGITS + "자리의 숫자를 공백, 문자 없이 연속하여 입력해주십시오.");
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
        if (!playerInput.equals("1") && !playerInput.equals("2")) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)를 입력해주세요.");
        }
        quitNumber = playerInput;
    }
}

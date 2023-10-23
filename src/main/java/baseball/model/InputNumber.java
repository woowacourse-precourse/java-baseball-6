package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputNumber {
    private static final int NUMBER_OF_DIGITS = 3;
    private List<Integer> inputNumber = new ArrayList<>();
    private String quitNumber = "";

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String playerInput) throws IllegalArgumentException {
        if (playerInput.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException(NUMBER_OF_DIGITS + "자리의 수를 입력해주십시오.");
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

package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private List<Integer> inputNumber = new ArrayList<>();

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String playerInput) throws IllegalArgumentException {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주십시오.");
        }

        for (int i = 0; i < playerInput.length(); i++) {
            char letter = playerInput.charAt(i);
            inputNumber.add(Integer.parseInt(String.valueOf(letter)));
        }
    }
}

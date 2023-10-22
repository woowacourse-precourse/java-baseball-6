package baseball.model;

public class InputNumber {
    private int inputNumber;

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String playerInput) throws IllegalArgumentException {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주십시오.");
        }
        inputNumber = Integer.parseInt(playerInput);
    }
}

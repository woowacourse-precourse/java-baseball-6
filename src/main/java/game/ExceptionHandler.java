package game;

public class ExceptionHandler {
    public void NumberSizeExceed(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void UnexpectedValue(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) < '1' || inputNumber.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    public void DuplicatedValue(String inputNumber) {
        if (inputNumber.charAt(0) == inputNumber.charAt(1) ||
                inputNumber.charAt(0) == inputNumber.charAt(2) ||
                inputNumber.charAt(1) == inputNumber.charAt(2)
        ) {
            throw new IllegalArgumentException();
        }
    }
}

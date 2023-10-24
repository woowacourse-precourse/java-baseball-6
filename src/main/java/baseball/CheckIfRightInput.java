package baseball;

public class CheckIfRightInput {

    String inputNum;
    private static final int numLength = 3;

    public CheckIfRightInput(String inputNum) {
        this.inputNum = inputNum;
        checkInputLength(inputNum);
        checkInputDigit(inputNum);
    }

    private void checkInputLength(String inputNum) {
            if (inputNum.length() != numLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputDigit (String inputNum) {
        for (int i=0; i<numLength; i++) {
            if (!Character.isDigit(inputNum.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}

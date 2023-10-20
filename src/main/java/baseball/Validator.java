package baseball;

public class Validator {

    public boolean validateGuessNumber(String inputValue) {

        char[] inputCharArray = inputValue.toCharArray();

        return isNumbers(inputCharArray) && isThreeLength(inputCharArray);
    }

    private boolean isNumbers(char[] inputCharArray) {

        for (char ch : inputCharArray) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeLength(char[] inputCharArray) {

        return inputCharArray.length == 3;

    }

}

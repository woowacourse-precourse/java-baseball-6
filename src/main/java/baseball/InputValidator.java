package baseball;

public class InputValidator {
    public boolean checkInput(String input){
        int userInput = getIntegerValue(input);

        return isInputThreeNumbers(input) && isDuplicated(input) && userInput != -1;
    }

    private boolean isInputThreeNumbers(String input) {
        return input.length() == 3;
    }

    private int getIntegerValue(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (Exception ex) {
            return -1;
        }
    }

    private boolean isDuplicated(String input) {
        boolean[] numberArray = new boolean[10];

        for(int index = 0; index < input.length(); index++)
        {
            int number = input.charAt(index)-'0';
            if (numberArray[number]) {
                return false;
            }
            numberArray[number] = true;
        }
        return true;
    }
}

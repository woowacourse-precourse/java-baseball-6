package baseball;

public class CheckingInput {

    public void checkAll(String input) throws IllegalArgumentException {
        if (!(checkRange(input) && checkDifference(input))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkRange(String input) {
        Integer int_input = Integer.parseInt(input);
        return int_input > 111 && int_input < 999;
    }

    public boolean checkDifference(String input) {
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        return firstNum != secondNum && secondNum != thirdNum && thirdNum != firstNum;
    }

}

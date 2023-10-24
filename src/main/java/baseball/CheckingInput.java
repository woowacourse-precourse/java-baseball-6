package baseball;

public class CheckingInput {

    public void checkAll(String input) throws IllegalArgumentException {
        if ((checkRange(input) && checkDifference(input)) == false) {
            throw new IllegalArgumentException();
        }
    }
    public boolean checkRange(String input) {
        Integer int_input = Integer.parseInt(input);
        if (int_input > 111 && int_input < 999) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkDifference(String input) {
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum= input.charAt(2);
        if (firstNum != secondNum && secondNum != thirdNum && thirdNum != firstNum) {
            return true;
        } else {
            return false;
        }
    }

}

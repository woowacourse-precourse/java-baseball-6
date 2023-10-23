package baseball.utils;

public class InputValidator {

    public void validate(String stringInput) {
        if (isInputIsNum(stringInput) || stringInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        int first = Character.getNumericValue(stringInput.charAt(0));
        int second = Character.getNumericValue(stringInput.charAt(1));
        int third = Character.getNumericValue(stringInput.charAt(2));

        if (isElementsAreSame(first, second, third) || isElementsAreNotZero(first, second, third)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputIsNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private boolean isElementsAreSame(int first, int second, int third) {
        return first == second || second == third || first == third;
    }


    private boolean isElementsAreNotZero(int first, int second, int third) {
        return first == 0 || second == 0 || third == 0;
    }
}

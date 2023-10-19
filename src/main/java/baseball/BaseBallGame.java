package baseball;

public class BaseBallGame {

    private boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isUniqueDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if(input.indexOf(input.charAt(i)) != i) {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeDigit(String input) {
        return input.length() == 3;
    }
}

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
}

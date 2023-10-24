package baseball.controller;
import baseball.model.NumberRule;
public class InputControl {
    NumberRule NR = new NumberRule();
    public boolean isValidString(String input) {
        if(!NR.isNotDuplicate(input) || !NR.isNumber(input) || !NR.isThreeDigits(input)) {
            return false;
        }
        return true;
    }
}

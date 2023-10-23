package baseball;

public class Validation {
    public boolean isDigitInput(String num) {
        boolean flag = true;

        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}

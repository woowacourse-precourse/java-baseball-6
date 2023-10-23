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

    public boolean isThreeLength(String num) {
        boolean flag = true;

        if (num.length() != 3) {
            flag = false;
        }

        return flag;
    }

    public boolean isOneLength(String num) {
        boolean flag = true;

        if (num.length() != 1) {
            flag = false;
        }

        return flag;
    }
}

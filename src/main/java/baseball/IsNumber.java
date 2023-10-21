package baseball;

public class IsNumber {

    public Boolean isNum(String s) {
        if (s.length() == 3 && isInteger(s)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isInteger(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}

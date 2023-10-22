package baseball;

public class Validate {
    private String number;

    Validate() {

    }

    public void validateInput(String number) {
        this.number = number;
        if (number.length() != 3 || checkZeroValue()==false) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkZeroValue() {
        for (int i = 0; i < this.number.length(); i++) {
            if (number.charAt(i) <= '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}

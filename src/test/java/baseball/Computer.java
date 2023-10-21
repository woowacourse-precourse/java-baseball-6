package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String number;

    public String generateRandomNumber() {
        String number = numberToString();
        while (validationDifferentNumber(number)) {
            number = numberToString();
        }
        this.number = number;
        return this.number;
    }

    private boolean validationDifferentNumber(String number) {
        return number.charAt(0) == number.charAt(1) ||
                number.charAt(1) == number.charAt(2) ||
                number.charAt(0) == number.charAt(2);
    }

    private String numberToString() {
        return String.valueOf(Randoms.pickNumberInRange(100, 999));
    }
}

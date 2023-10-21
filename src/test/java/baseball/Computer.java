package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String number;

    public String generateRandomNumber() {
        String number = String.valueOf(Randoms.pickNumberInRange(100, 999));

        while (number.charAt(0) == number.charAt(1) ||
                number.charAt(1) == number.charAt(2) ||
                number.charAt(0) == number.charAt(2)) {
            number = String.valueOf(Randoms.pickNumberInRange(100, 999));
        }

        this.number = number;
        return this.number;
    }
}

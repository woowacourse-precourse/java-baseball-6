package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String number;
    public String generateRandomNumber() {
        int num1 = Randoms.pickNumberInRange(1, 9);
        int num2 = Randoms.pickNumberInRange(1, 9);
        while (num1 == num2) {
            num2 = Randoms.pickNumberInRange(1, 9);
        }
        int num3 = Randoms.pickNumberInRange(1, 9);
        while (num3 == num1 || num3 == num2) {
            num3 = Randoms.pickNumberInRange(1, 9);
        }

        String numToString = String.valueOf(num1);
        String numToString2 = String.valueOf(num2);
        String numToString3 = String.valueOf(num3);

        this.number = numToString + numToString2 + numToString3;
        return this.number;
    }
}

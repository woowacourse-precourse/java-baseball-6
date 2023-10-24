package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class p {
    public String setRandomDistinctNumbers() {

        StringBuilder number = new StringBuilder();

        while (number.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!number.equals(String.valueOf(randomNumber))) {
                number.append(randomNumber);
            }
        }
        return number.toString();
    }

    public void checkInputValidation(String input) {

        if (input.length() != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        char[] digits = input.toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    public static void main(String[] args) {
        p p = new p();
        p.checkInputValidation("가나");
    }
}

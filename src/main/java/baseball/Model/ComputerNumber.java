package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {

    private static int NUMBER_RANGE_START = 1;
    private static int NUMBER_RANGE_END = 9;

    private String number;

    public void GeneratedRandomNumber() {

        StringBuilder sb = new StringBuilder();

        while (sb.length() < 3) {
            String newNumber = String.valueOf(Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END));
            if (!sb.toString().contains(newNumber)) {
                sb.append(newNumber);
            }
        }

        this.number = sb.toString();
    }

    public String getNumber() {
        return number;
    }
}

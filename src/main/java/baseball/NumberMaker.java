package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {
    public static String getRandomNumber() {
        Boolean[] isUsed = new Boolean[10];

        for (int i = 1; i <= 9; i++) {
            isUsed[i] = false;
        }

        StringBuilder result = new StringBuilder();

        while (result.length() < 3) {
            Integer temp = Randoms.pickNumberInRange(1, 9);

            if (!isUsed[temp]) {
                isUsed[temp] = true;
                result.append(temp);
            }
        }

        return result.toString();
    }
}

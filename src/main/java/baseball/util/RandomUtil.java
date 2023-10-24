package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static String CreateRandomNum() {
        String randomNumComputer = "";
        while (randomNumComputer.length() < 3) {
            String randomNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!randomNumComputer.contains(randomNum)) {
                randomNumComputer += randomNum;
            }
        }
        return randomNumComputer;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    public static String createValue() {
        StringBuilder computerInput = new StringBuilder();
        while (computerInput.length() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerInput.toString().contains(randomNumber)) {
                computerInput.append(randomNumber);
            }
        }
        return computerInput.toString();
    }
}

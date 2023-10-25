package baseball;

import camp.nextstep.edu.missionutils.Randoms;
    public class RandomNumberGenerator {
        public static String makeRandomNumber() {
            String randomNumber= "";
            while (randomNumber.length() < 3) {
                String n = String.valueOf(Randoms.pickNumberInRange(1,9));
                if (!randomNumber.contains(n)) {
                    randomNumber += n;
                }
            }
            return randomNumber;
        }
}

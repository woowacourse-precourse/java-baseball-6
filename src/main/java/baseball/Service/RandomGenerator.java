package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomGenerator {

    public static String getRandomNumber() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return Integer.toString(numbers[0] * 100 + numbers[1] * 10 + numbers[2]);
    }

}

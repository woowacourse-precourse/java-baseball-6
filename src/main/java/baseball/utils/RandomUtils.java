package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int getUniqueRandomNumber(int[] numbers, int start, int end, int i) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        /** numbers 배열안에 있는 숫자와 서로 다른 숫자가 될 수 있도록 램덤하게 숫자를 뽑는다**/
    }
}

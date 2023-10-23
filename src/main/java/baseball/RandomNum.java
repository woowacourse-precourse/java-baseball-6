package baseball;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNum {
    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = Randoms.pickNumberInRange(start, end);

            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    }
}

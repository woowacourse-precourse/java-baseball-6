package random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomArray {

    public static int[] makeRandomArray(int start, int end, int size) {
        int[] array = new int[size];
        boolean[] used = new boolean[end - start + 1];
        int index = 0;
        while (index != size) {
            int randomNum = Randoms.pickNumberInRange(start, end);
            index = pickUniqueNumber(array, used, index, randomNum);
        }
        return array;
    }

    private static int pickUniqueNumber(int[] array, boolean[] used, int index, int randomNum) {
        if (!used[randomNum]) {
            array[index] = randomNum;
            used[randomNum] = true;
            index++;
        }
        return index;
    }
}

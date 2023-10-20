package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final int size = 3;
    private final int[] arr = new int[size];

    public int[] setRandomNum() {
        int size = arr.length;
        int count = 0;
        while (count < size) {
            int r = Randoms.pickNumberInRange(1, 9);
            boolean check = false;

            for (int i = 0; i < size; i++) {
                if (arr[i] == r) {
                    check = true;
                    break;
                }
            }


            if (!check) {
                arr[count] = r;
                count += 1;
            }
        }
        return arr;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final Computer instance = new Computer();
    private static final int SIZE = 3;
    private static int[] arr = new int[SIZE];
    private Computer() {}
    public static Computer getInstance() {
        return instance;
    }

    public int[] setRandomNums() {
        Set<Integer> set = new HashSet<>();

        int count = 0;
        while (set.size() < SIZE) {
            int r = Randoms.pickNumberInRange(1, 9);
            set.add(r);
        }

        for (Integer num : set) {
            arr[count] = num;
            count += 1;
        }
        return arr;
    }

    public void resetNums() {
        arr = setRandomNums();
    }


    // set 을 사용하지 않으니 타임오버 예외가 발생하였다.
//    public int[] setRandomNum() {
//        int count = 0;
//        while (count < SIZE) {
//            int r = Randoms.pickNumberInRange(1, 9);
//            boolean check = false;
//
//            for (int i = 0; i < SIZE; i++) {
//                if (arr[i] == r) {
//                    check = true;
//                    break;
//                }
//            }
//
//            if (!check) {
//                arr[count] = r;
//                count += 1;
//            }
//        }
//        return arr;
//    }
}

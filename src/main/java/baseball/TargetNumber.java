package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class TargetNumber {
    private int[] number = new int[3];

    private TargetNumber() {
        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int value = Randoms.pickNumberInRange(1, 9);
            while (duplicationCheck[value]) value = Randoms.pickNumberInRange(1, 9);
            duplicationCheck[value] = true;
            number[i] = value;
        }
    }

    public static TargetNumber generate() { return new TargetNumber(); }

    public boolean[] has(int num, int idx) {
        boolean[] check = new boolean[2];
        for (int i = 0; i < 3; i++) {
            if (number[i] == num) {
                if (i == idx) check[1] = true;
                check[0] = true;
                break;
            }
        }
        return check;
    }
}

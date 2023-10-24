package baseball.service;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumber {

    public void createRandomNumber() {
        int[] num = new int[3];
        int i = 0;
        int j = 0;
        while (CheckRegenerateNumber(i)) {
            for (; i < num.length; i++) {
                num[i] = Randoms.pickNumberInRange(1, 9);
                i = regenerateNumbers(num, i);
            }

        }
        Number.setComputerNumber(num);

    }

    public int regenerateNumbers(int[] num, int idx) {
        for (int i = 0; i < idx; i++) {
            if (duplicateCheckNumber(num, i, idx)) {
                return idx - 1;
            }
        }
        return idx;
    }

    public boolean duplicateCheckNumber(int[] num, int i, int j) {
        if (num[i] == num[j]) {
            return true;
        }
        return false;
    }

    public boolean CheckRegenerateNumber(int i) {
        if (i < 3) {
            return true;
        }
        return false;
    }
}

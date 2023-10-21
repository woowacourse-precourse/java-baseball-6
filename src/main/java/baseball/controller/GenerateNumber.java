package baseball.controller;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumber {

    public void createRandomNumber() {

        int num[] = new int[3];
        int i = 0;
        int j = 0;
        while (CheckRegenerateNumber(i)) {
            for (; i < num.length; i++) {
                num[i] = Randoms.pickNumberInRange(1, 9);
            }
            i = regenerateNumbers(num);
        }
        Number number = new Number();
        number.setComputerNumber(num);

    }

    public int regenerateNumbers(int[] num) {
        int i = 0;
        for (int j = i + 1; j < 3; j++) {
            if (duplicateCheckNumber(num, i, j)) {
                return j;
            }
            i++;
        }
        return i + 1;
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
        /*for (int i = 0; i < 3; i++) {
            System.out.println(num[i]);
        }
        return num;*/

	            /*if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (num[i] == num[j]) {
                        i--;
                        break;
                    }
                }
            }*/
}

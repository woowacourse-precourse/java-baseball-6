package baseball.service;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumber {

    public void createRandomNumber() {
        /*List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Number number = new Number();
        number.setComputerNumber(computer.toString());*/
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
        //System.out.println(Arrays.toString(number.getComputerNumber()));

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

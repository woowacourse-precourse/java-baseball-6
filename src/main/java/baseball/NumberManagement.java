package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManagement {

    private int[] numbers;
    private boolean[] numberFlag;

    NumberManagement() {
        numbers = new int[3];
        numberFlag = new boolean[10];
    }

    public void close() {
        numbers = null;
        numberFlag = null;
    }

    public void makeNumbers(int idx) {
        if(idx == 3) { return; }
        int number = Randoms.pickNumberInRange(0, 8) + 1;
        if(numberFlag[number]) {
            makeNumbers(idx);
        } else {
            numberFlag[number] = true;
            numbers[idx] = number;
            makeNumbers(idx + 1);
        }
    }

    public void clear() {
        for(int i = 0; i < 3; i++) {
            numberFlag[numbers[i]] = false;
        }
    }



}

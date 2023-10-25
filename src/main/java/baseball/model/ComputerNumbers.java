package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerNumbers {

    public final int size = 3;
    public Number[] numbers;

    public ComputerNumbers() {
        this.numbers = pickRandomNums();
    }

    public ComputerNumbers(Number[] nums){
        this.numbers=nums;
    }

    public Number[] pickRandomNums() {
        int[] numStorage = new int[size];

        for (int i = 0; i < size; i++) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (isDuplicate(randomNum, numStorage)) {
                i--;
                continue;
            }
            numStorage[i] = randomNum;
        }

        return new Number[]{new Number(numStorage[0]), new Number(numStorage[1]), new Number(numStorage[2])};
    }

    private boolean isDuplicate(int randomNum, int[] numStorage) {
        for (int i = 0; i < size; i++) {
            if (numStorage[i] == randomNum) {
                return true;
            }
        }
        return false;
    }
}

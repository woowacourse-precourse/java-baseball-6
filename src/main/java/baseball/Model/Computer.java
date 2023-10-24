package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] computerNumbers = new int[3];

    private void createNumber() {
        for (int i = 0; i < 3; i++) {
            calculateNumber(i);
        }
    }

    private void calculateNumber(int index) {
        var randomNum = Randoms.pickNumberInRange(1, 9);
        computerNumbers[index] = randomNum;

        if (nonDuplicateNumber(randomNum, index) == false) {
            calculateNumber(index);
        }
    }

    private boolean nonDuplicateNumber(int randomNum, int index) {
        for (int i = 0; i < index; i++) {
            if (randomNum == computerNumbers[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getComputerNumber() {
        createNumber();
        return computerNumbers;
    }
}

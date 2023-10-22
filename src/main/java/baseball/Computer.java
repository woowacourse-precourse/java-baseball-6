package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;
    private static final int INPUT_LENGTH = 3;
    int[] computerNumber = new int[INPUT_LENGTH];

    public void setComputerNumber() {
        boolean[] usedNumbers = new boolean[RANGE_MAX + 1];
        int i = 0;
        while(i != 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            if(usedNumbers[randomNumber]){
                continue;
            }
            usedNumbers[randomNumber] = true;
            this.computerNumber[i] = randomNumber;
            i++;
        }
    }


}

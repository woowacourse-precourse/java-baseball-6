package baseball;

import camp.nextstep.edu.missionutils.Randoms;


public class randomNumberGenerator {

    public static int[] generateComputer() {
        int[] computer = new int[3];
        int num = Randoms.pickNumberInRange(1, 9);
        computer[0] = num;
        for (int i=1; i<3; i++) {
            while (num == computer[i-1]) {
                num = Randoms.pickNumberInRange(1, 9);
            }
            computer[i] = num;
        }
        return computer;
    }
}

package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberCreator {
    static final int NUMBER_DIGIT = 3;


    private static int[] listTransformToIntArray(List<Integer> number) {
        int[] intArrayNumber = new int[NUMBER_DIGIT];

        for (int i = 0; i < NUMBER_DIGIT; i++) {
            {
                intArrayNumber[i] = number.get(i);
            }
        }
        return intArrayNumber;
    }

    public int[] createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return listTransformToIntArray(computer);
    }


}

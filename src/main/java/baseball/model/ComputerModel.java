package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class ComputerModel {

    public int[] computerNumbers;

    public ComputerModel() {
        do {
            computerNumbers = createComputerNumbers();
        } while(Util.isDuplicateNumber(computerNumbers));
    }

    private static int[] createComputerNumbers() {
        return Arrays.stream(new int[3])
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .toArray();
    }

}

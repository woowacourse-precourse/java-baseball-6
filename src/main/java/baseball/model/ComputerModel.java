package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class ComputerModel {

    public int[] computerNumbers;

    public ComputerModel() {
        computerNumbers = createComputerNumbers();
    }

    private static int[] createComputerNumbers() {
        return Arrays.stream(new int[100])
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .toArray();
    }

}

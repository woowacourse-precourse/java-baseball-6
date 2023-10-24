package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ComputerUtil {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;

    /*
     * 3자리 숫자 생성 (중복X)
     * */
    public static List<Integer> generateComputerNumber() {
        LinkedHashSet<Integer> computerNumber = new LinkedHashSet<>();

        while (computerNumber.size() < NUMBER_SIZE) {
            computerNumber.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

        return new ArrayList<>(computerNumber);
    }
}

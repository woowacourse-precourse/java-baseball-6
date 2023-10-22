package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Computer {
    public static LinkedHashSet<Integer> generatedNumbers(){
        return new LinkedHashSet<>(Randoms.pickUniqueNumbersInRange(1,9,3));
    }
}

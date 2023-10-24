package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class NumberGenerator {

    public static LinkedHashSet<Integer> numberGenerating(int end) {
        LinkedHashSet<Integer> intSpace = new LinkedHashSet<>();

        while (intSpace.size() != end) {
            intSpace.add(Randoms.pickNumberInRange(1, 9));
        }
        return intSpace;
    }
}

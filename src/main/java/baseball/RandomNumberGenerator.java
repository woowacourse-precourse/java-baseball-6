package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomNumberGenerator {

    private static Set<Integer> set;

    public static String generateRandomNumber() {
        set = new HashSet<>();
        while (set.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }

        StringBuffer sb = new StringBuffer();
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
        }
        return sb.toString();
    }
}

package game;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomNumberGenerator {

    private static Set<Integer> set;

    public static String generateRandomNumber() {
        set = new HashSet<>();
        while (set.size() < Constants.BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }
        return getStringNumber();
    }

    private static String getStringNumber() {
        StringBuffer sb = new StringBuffer();
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
        }
        return sb.toString();
    }
}

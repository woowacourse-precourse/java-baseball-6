package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber(int length) {
        Set<Integer> set = new HashSet<>();
        while (set.size() != length) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        int answer = 0;
        for (Integer integer : set) {
            answer *= 10;
            answer += integer;
        }
        return answer;
    }
}

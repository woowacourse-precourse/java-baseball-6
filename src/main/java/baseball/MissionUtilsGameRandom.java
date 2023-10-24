package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import game.GameRandom;
import java.util.HashSet;
import java.util.Set;

public class MissionUtilsGameRandom implements GameRandom {
    @Override
    public int[] sampleDistinctNumbers(int startInclusive, int endInclusive, int length) {
        assert (startInclusive <= endInclusive && length <= endInclusive - startInclusive + 1);
        Set<Integer> set = new HashSet<>();
        int[] result = new int[length];

        while (set.size() < length) {
            int number = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!set.contains(number)) {
                result[set.size()] = number;
            }
            set.add(number);
        }

        return result;
    }
}

package utils;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Constant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtil {
    public static List<Integer> generateBaseballNumber() {
        Set<Integer> nonDuplicateNmbs = new HashSet<>();

        while (nonDuplicateNmbs.size() < Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue()) {
            int randomNmb = Randoms.pickNumberInRange(Constant.BASEBALL_GAME_NUMBER_RANGE_START_VALUE.getValue(),
                    Constant.BASEBALL_GAME_NUMBER_RANGE_LAST_VALUE.getValue());
            nonDuplicateNmbs.add(randomNmb);
        }

        return nonDuplicateNmbs.stream().collect(Collectors.toList());
    }
}

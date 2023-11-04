package baseball;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    public String createGameValue() {
        // 컴퓨터 수 생성
        Set<Integer> targetSet = new HashSet<>();
        while (targetSet.size() < 3) {
            targetSet.add(pickNumberInRange(1, 9));
        }

        return targetSet.stream()
                .map(String::valueOf)
                .reduce("", String::concat);
    }
}

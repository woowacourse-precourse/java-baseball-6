package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    public List<Integer> createRandomList() {
        List<Integer> randomNumbers = new ArrayList<>();
        boolean[] visited = new boolean[10];

        for (int i = 0; i < 3; ) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (visited[randNum]) {
                continue;
            }
            visited[randNum] = true;
            randomNumbers.add(randNum);
            i++;
        }

        return randomNumbers;
    }
}

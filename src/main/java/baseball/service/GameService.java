package baseball.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class GameService {

    public List<Integer> generateRandomDistinctThreeDigit() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}

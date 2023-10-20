package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> generateNumber(int numberLength) {
        List<Integer> gameNumber = new ArrayList<>();
        while(gameNumber.size() != numberLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameNumber.contains(randomNumber)) {
                gameNumber.add(randomNumber);
            }
        }
        return gameNumber;
    }
}

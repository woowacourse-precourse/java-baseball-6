package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameMaker {

    public static List<Integer> createGameMaker() {
        List<Integer> computerNumbers = new ArrayList<>();
        for (int i = 0; computerNumbers.size() < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add((number));
            }
        }
        return computerNumbers;
    }
}

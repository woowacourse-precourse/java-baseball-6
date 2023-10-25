package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    public static final int NUMBER_LENGTH = 3;
    public static final int STRIKE_OUT = 3;
    public static final int GAME_START = 1;
    public static final int GAME_END = 2;

    public static List<Integer> randomNumberGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


}

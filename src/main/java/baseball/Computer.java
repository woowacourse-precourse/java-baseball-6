package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    static final int MAX_NUMBER = 9;
    static final int MIX_NUMBER = 1;
    static final int NUMBER_SIZE = 3;

    public void generationRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIX_NUMBER, MAX_NUMBER);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}

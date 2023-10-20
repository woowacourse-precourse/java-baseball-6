package baseball.util;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Randomutil {

    public static LinkedList<Integer> CreateRandomNum() {
        LinkedList<Integer> randomNumComputer = new LinkedList<>();
        while (randomNumComputer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNumComputer.contains(randomNum)){
                randomNumComputer.add(randomNum);
            }
        }
        return randomNumComputer;
    }
}

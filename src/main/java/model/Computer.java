package model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import global.Constants;

public class Computer {

    private static Computer instance = new Computer();
    private static List<Integer> randomNumber = new ArrayList<Integer>();

    private Computer() { }

    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

    public List<Integer> getRandomNumber() { return randomNumber; }

    public void setRandomNumber() {
        randomNumber.clear();

        randomNumber.add(Randoms.pickNumberInRange(1,9));
        while (randomNumber.size() < Constants.RANDOM_NUM_LENGTH) {
            int num = Randoms.pickNumberInRange(1,9);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
    }
}

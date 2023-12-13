package baseball.service;

import static baseball.util.Constants.BASEBALL_SIZE;
import static baseball.util.Constants.END_NUM;
import static baseball.util.Constants.START_NUM;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    public Numbers randomGenerate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < BASEBALL_SIZE) {
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!randomNumbers.contains(randomNum)) {
                randomNumbers.add(randomNum);
            }
        }
        return new Numbers(randomNumbers);
    }

}

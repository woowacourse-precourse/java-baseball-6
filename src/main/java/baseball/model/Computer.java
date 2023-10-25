package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Const.*;


public class Computer {

    List<Integer> targetNum = new ArrayList<>();

    public static Computer createRandomNumbers() {
        return new Computer(generateNumbers());
    }

    private Computer(List<Integer> randomNumbers) {
        this.targetNum = randomNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return this.targetNum;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != MAX_NUMBER_SIZE) {
            checkDuplicatedAndInsert(Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE),numbers);
        }
        return numbers;
    }

    public static void checkDuplicatedAndInsert(int number, List<Integer>list) {
        if(!list.contains(number)){
            list.add(number);
        }
    }

}

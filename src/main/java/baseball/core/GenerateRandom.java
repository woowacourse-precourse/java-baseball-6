package baseball.core;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandom {

    public static List<Integer> generateRandomNumberByList(int generate_cnt){
        List<Integer> computer_numbers = new ArrayList<>();
        while (computer_numbers.size() < generate_cnt) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_numbers.contains(randomNumber)) {
                computer_numbers.add(randomNumber);
            }
        }
        return computer_numbers;
    }
}

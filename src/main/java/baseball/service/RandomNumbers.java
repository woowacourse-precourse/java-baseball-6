package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private List<Integer> numbers = new ArrayList<>();

    public RandomNumbers(){
        this.numbers=generateRandomNumbers();
    }
    private List<Integer> generateRandomNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public String toString() {
        return "RandomNumbers: "+numbers;
    }
}

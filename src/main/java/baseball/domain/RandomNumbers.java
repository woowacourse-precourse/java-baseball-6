package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    private List<Integer> computerNumberList;

    public RandomNumbers() {
        this.computerNumberList = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }
}

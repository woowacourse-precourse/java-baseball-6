package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private List<Integer> randomNumber;

    public RandomNumber() {
        this.randomNumber = create();
    }

    private List<Integer> create() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public boolean numberExistsInList(Integer numberAtIndex) {
        return randomNumber.contains(numberAtIndex);
    }

    public Integer getNumberAtIndex(int index) {
        return this.randomNumber.get(index);
    }

    public void reset() {
        randomNumber.clear();
        this.randomNumber = create();
    }
}

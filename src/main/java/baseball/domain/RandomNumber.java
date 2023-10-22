package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private List<Integer> randomNumber;

    public static RandomNumber create() {
        ArrayList<Integer> computer = makeRandomNumberList();
        return new RandomNumber(computer);
    }

    private RandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    private static ArrayList<Integer> makeRandomNumberList() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < GameNumberSet.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer); //Todo: 지워야 함
        return computer;
    }

    public boolean numberExistsInList(Integer numberAtIndex) {
        return randomNumber.contains(numberAtIndex);
    }

    public Integer getNumberAtIndex(int index) {
        return this.randomNumber.get(index);
    }

    public void reset() {
        this.randomNumber = makeRandomNumberList();
    }
}

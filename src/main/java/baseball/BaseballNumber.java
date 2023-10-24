package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class BaseballNumber {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public void setComputerNumbers() {
        numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public void setUserNumbers(ArrayList<Integer> numbers) {
        this.numbers.clear();
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
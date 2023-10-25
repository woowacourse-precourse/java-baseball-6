package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private final List<Integer> numbers;
    private int numberOfStrike;
    private int numberOfBall;

    public Game() {
        this.numbers = new ArrayList<>();
        this.numberOfStrike = 0;
        this.numberOfBall = 0;
    }

    public void init() {
        numbers.clear();
        numberOfStrike = 0;
        numberOfBall = 0;
        getThreeRandomNumbers();
    }

    public void reset() {
        numberOfStrike = 0;
        numberOfBall = 0;
    }

    public void countStrikeOrBall(List<Integer> prediction) {
        for (int i = 0; i < prediction.size(); i++) {
            if (prediction.get(i).equals(numbers.get(i))) {
                numberOfStrike++;
                continue;
            }
            if (numbers.contains(prediction.get(i))) {
                numberOfBall++;
            }
        }
    }

    private void getThreeRandomNumbers() {
        int k = 3;
        while (k > 0) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
                k--;
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumberOfStrike() {
        return numberOfStrike;
    }

    public int getNumberOfBall() {
        return numberOfBall;
    }
}

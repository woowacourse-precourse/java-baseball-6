package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.Config.*;

public class Computer {
    public final ArrayList<Integer> generatedNumbers;

    public Computer() {
        this.generatedNumbers = getNumbers(INPUT_NUMBER_LENGTH);
    }
    private static ArrayList<Integer> getNumbers(int count) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            int number = Randoms.pickNumberInRange(RANDOM_NUMBER_START,RANDOM_NUMBER_END);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public ArrayList<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }
}
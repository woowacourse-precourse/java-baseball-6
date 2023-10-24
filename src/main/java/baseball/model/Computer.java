package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    public final ArrayList<Integer> generatedNumbers;

    public Computer() {
        this.generatedNumbers = getNumbers(3);
    }
    private static ArrayList<Integer> getNumbers(int count) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            int number = Randoms.pickNumberInRange(1,9);
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
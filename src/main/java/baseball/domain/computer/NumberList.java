package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberList {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int LIMIT_NUMBER = 3;
    private final List<Integer> numbers;


    public NumberList() {
        this.numbers = generateComputerNumber();
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public int get(final int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        addIterating(computer);
        return computer;
    }

    private static void addIterating(final List<Integer> computer) {
        while (computer.size() < LIMIT_NUMBER) {
            addNums(computer);
        }
    }

    private static void addNums(final List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        isContained(computer, randomNumber);
    }

    private static void isContained(final List<Integer> computer, final int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}

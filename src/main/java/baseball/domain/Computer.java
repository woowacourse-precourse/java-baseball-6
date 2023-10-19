package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> computerNumbers;

    public Computer(int size) {
        computerNumbers = generateComputerNumbers(size);
    }

    private List<Integer> generateComputerNumbers(int size) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            uniqueNumbers.add(randomNumber);
        }
        return new ArrayList<>(uniqueNumbers);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}

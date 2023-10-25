package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumber {

    private final String value;

    public ComputerNumber() {
        this.value = getRandomNumber();
    }

    private String getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }

    public String getValue() {
        return value;
    }
}

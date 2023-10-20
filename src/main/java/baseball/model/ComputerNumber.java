package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.stream.Collectors.joining;

import java.util.List;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        this.computerNumber = pickRandomNumber(NUMBER_LENGTH);
    }

    public String pickRandomNumber(int numLength) {
        List<Integer> pickedInteger = pickUniqueNumbersInRange(1, 9, numLength);
        return convertIntegerListToString(pickedInteger);
    }

    private String convertIntegerListToString(List<Integer> pickedInteger) {
        return pickedInteger.stream()
            .map(Object::toString)
            .collect(joining(""));
    }
}

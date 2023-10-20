package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.stream.Collectors.joining;

import java.util.List;

public class ComputerNumber {

    public String pickTargetNumber(int numLength) {
        List<Integer> pickedInteger = pickUniqueNumbersInRange(1, 9, numLength);
        return convertIntegerListToString(pickedInteger);
    }

    private String convertIntegerListToString(List<Integer> pickedInteger) {
        return pickedInteger.stream()
            .map(Object::toString)
            .collect(joining(""));
    }
}

package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberUtil {
    private static final int COMPUTER_GENERATE_NUMBER_SIZE = 3;
    private static final int GENERATE_NUMBER_MAX = 9;
    private static final int GENERATE_NUMBER_MIN = 1;

    public List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_GENERATE_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(GENERATE_NUMBER_MIN, GENERATE_NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> convertStringToIntList(String inputNumber) {
        int[] convertIntArray = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(convertIntArray).boxed().collect(Collectors.toList());
    }

}
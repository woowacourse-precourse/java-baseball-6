package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public List<Integer> generatorComputerNumber(int baseballNumSize) {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < baseballNumSize) {
            int num = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }

    public List<Integer> parseUserInput(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
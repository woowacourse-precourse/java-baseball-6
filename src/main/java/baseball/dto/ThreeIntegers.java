package baseball.dto;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ThreeIntegers {
    private final List<Integer> integers;

    private ThreeIntegers(List<Integer> integers) {
        Objects.requireNonNull(integers);

        this.integers = integers;
    }

    private ThreeIntegers(String inputValue) {
        Objects.requireNonNull(inputValue);
        this.integers = Arrays.stream(inputValue.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static ThreeIntegers createRandomThreeIntegers() {
        List<Integer> pickedIntegers = new ArrayList<>();
        while (pickedIntegers.size() < 3) {
            int pickedInteger = pickNumberInRange(1, 9);
            addRandomUniqueInteger(pickedIntegers, pickedInteger);
        }
        return new ThreeIntegers(pickedIntegers);
    }

    private static void addRandomUniqueInteger(List<Integer> pickedIntegers, int pickedInteger) {
        Objects.requireNonNull(pickedIntegers);

        if (!pickedIntegers.contains(pickedInteger)) {
            pickedIntegers.add(pickedInteger);
        }
    }

    public Score calculateScoreFrom(String inputValue) {
        Objects.requireNonNull(inputValue);

        List<Integer> inputIntegers = new ThreeIntegers(inputValue).getIntegers();

        return Score.from(inputIntegers, integers);
    }

    private List<Integer> getIntegers() {
        return integers;
    }
}

package baseball.domain;

import static baseball.resources.GameConst.*;

import baseball.resources.GameConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserNum {
    private List<Integer> number;

    public UserNum(String inputNum) {
        validation(strToList(inputNum));
        this.number = strToList(inputNum);
    }

    public List<Integer> getNum() {
        return number;
    }

    private void validation(List<Integer> inputNum) {
        checkLength(inputNum);
        checkContainZero(inputNum);
        duplicateNumCheck(inputNum);
    }

    private void checkLength(List<Integer> inputNum) {
        if (inputNum.size() != NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero(List<Integer> inputNum) {
        if (inputNum.contains(ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumCheck(List<Integer> inputNum) {
        long nonDuplicateNumSize = inputNum.stream()
                .distinct()
                .count();

        if (nonDuplicateNumSize != NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> strToList(String enterNum) {
        return Arrays.stream(enterNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}

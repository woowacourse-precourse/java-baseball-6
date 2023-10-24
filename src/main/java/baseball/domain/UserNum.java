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

    public UserNum() {
        this.number = new ArrayList<>();
    }

    public void setNum(String enterNum) {
        this.number = Arrays.stream(enterNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        validation();
    }

    public List<Integer> getNum() {
        return number;
    }

    private void validation() {
        checkLength();
        checkContainZero();
        duplicateNumCheck();
    }

    private void checkLength() {
        if (number.size() != NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero() {
        if (number.contains(ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumCheck() {
        long inputNumSize = number.stream()
                .distinct()
                .count();

        if (inputNumSize != NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}

package baseball.domain;

import static baseball.resources.GameConst.*;

import baseball.resources.GameConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserNum {
    private List<Integer> number;

    public UserNum() {
        this.number = new ArrayList<>();
    }

    public void setNum(String enterNum) {
        this.number = strToList(enterNum);
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

    private List<Integer> strToList(String enterNum) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < enterNum.length(); i++) {
            temp.add(enterNum.charAt(i) - '0');
        }
        return temp;
    }
}

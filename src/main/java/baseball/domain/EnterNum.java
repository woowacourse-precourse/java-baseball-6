package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EnterNum {
    private List<Integer> number;

    public EnterNum() {
        this.number = new ArrayList<>();
    }

    public void setNum(String enterNum) {
        this.number = strToList(enterNum);
    }

    public List<Integer> getNum() {
        return number;
    }

    public void validation() {
        checkLength();
        checkContainZero();
        duplicateNumCheck();
    }

    private void checkLength() {
        if (number.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero() {
        if (number.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumCheck() {
        HashSet<Integer> checkSet = new HashSet<>(number);

        if (checkSet.size() != 3) {
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

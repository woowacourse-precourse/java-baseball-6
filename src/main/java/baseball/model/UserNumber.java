package baseball.model;

import java.util.*;

public class UserNumber {
    private List<Integer> userNumber;

    public UserNumber(Integer input) {
        userNumber = new ArrayList<>();
        assignNumber(input);
        verifyUserNumber();
    }

    private void assignNumber(Integer input) {
        while (input / 10 != 0) {
            userNumber.add(0, input % 10);
            input /= 10;
        }

        userNumber.add(0, input % 10);
    }

    private void verifyUserNumber() {
        Set<Integer> userNumberSet = new HashSet<>(userNumber);
        if (userNumberSet.size() != userNumber.size()) {
            throw new IllegalArgumentException("For duplicated numbers");
        }

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("For incorrect size");
        }

    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(userNumber); // 불면성 보장을 위해 unmodifiableList 호출
    }


}

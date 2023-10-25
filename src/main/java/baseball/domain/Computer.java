package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Computer {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int NUMBER_SIZE = 3;
    private Number number;

    public Computer() {
        this.number = new Number(createNumber());
    }

    public List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Hint> getHint(List<Integer> usernumber) {
        List<Hint> hint = new ArrayList<>();

        for (int i = 0; i < NUMBER_SIZE; i++) {
            hint.add(getHintByIndex(i, usernumber.get(i)));
        }

        return hint;
    }

    private Hint getHintByIndex(int index, int number) {
        int result = getnumber().indexOf(number);
        if (result == index) {
            return Hint.STRIKE;
        }
        if (result == -1) {
            return Hint.NOTHING;
        }
        return Hint.BALL;
    }

    public List<Integer> getnumber() {
        return number.number;
    }

    public void setnumber() {
        this.number.setnumber(createNumber());
    }

    public void setNumber(Number testNumber) {
        this.number = testNumber;
    }
}
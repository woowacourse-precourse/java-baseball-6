package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Integer> numberList = new ArrayList<>();

    public void addNumber(int num) {
        if (isUnique(num))
            numberList.add(num);
    }

    private boolean isUnique(int num) {
        if (numberList.contains(num)) return false;
        return true;
    }

    public boolean isReady(int digit) {
        return (numberList.size() == digit);
    }

    @Override
    public String toString() {
        return Integer.toString(numberList.get(0) * 100
                + numberList.get(1) * 10
                + numberList.get(2));
    }
}

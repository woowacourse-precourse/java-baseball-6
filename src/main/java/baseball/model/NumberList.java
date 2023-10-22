package baseball.model;

import baseball.validator.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberList {
    private List<Integer> numberList;

    public NumberList(List<Integer> numberList) {
        Validator.validateSize(numberList, 3);
        validateRepeatedNumber(numberList);
        validateIsInRange(numberList);
        this.numberList = numberList;
    }

    public int size() {
        return numberList.size();
    }

    public Integer get(int index) {
        return numberList.get(index);
    }

    public static NumberList stringToNumberList(String numberString) {
        List<Integer> numberList = new ArrayList<>() {{
            for (int i = 0; i < numberString.length(); i++) {
                int number = numberString.charAt(i) - '0';
                add(number);
            }
        }};
        return new NumberList(numberList);
    }

    private void validateRepeatedNumber(List<Integer> numberList) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numberList.size(); i++) {
            set.add(numberList.get(i));
        }
        if (set.size() != numberList.size()) {
            throw new IllegalArgumentException("중복된 원소가 있습니다.");
        }
    }

    private void validateIsInRange(List<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            Validator.validateInRange(number, 1, 9);
        }
    }

    public boolean equals(NumberList a) {
        boolean isEqual = true;
        for (int i = 0; isEqual && i < numberList.size(); i++) {
            isEqual = (numberList.get(i).equals(a.numberList.get(i)));
        }
        return isEqual;
    }
}

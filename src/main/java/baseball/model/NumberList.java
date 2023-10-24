package baseball.model;

import baseball.validator.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberList {
    private List<Integer> numberList;

    public NumberList(List<Integer> numberList) {
        validate(numberList);
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
                add(numberString.charAt(i) - '0');
            }
        }};
        return new NumberList(numberList);
    }

    private void validate(List<Integer> numberList) {
        Validator.validateNull(numberList);
        Validator.validateSize(numberList, 3);
        validateIsInRange(numberList);
        validateRepeatedNumber(numberList);
    }

    private void validateIsInRange(List<Integer> numberList) {
        for (int number : numberList) {
            Validator.validateInRange(number, 1, 9);
        }
    }

    private void validateRepeatedNumber(List<Integer> numberList) {
        Set<Integer> set = new HashSet<>(numberList);
        if (set.size() != numberList.size()) {
            throw new IllegalArgumentException("중복된 원소가 있습니다.");
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

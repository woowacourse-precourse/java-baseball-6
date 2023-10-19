package baseball.domain;

import java.util.List;

public class Numbers {
    private List<Integer> numberList;

    private Numbers() {
    }

    public static Numbers create(List<Integer> numberList) {
        Numbers numbers  = new Numbers();
        numbers.setNumberList(numberList);

        return  numbers;
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}

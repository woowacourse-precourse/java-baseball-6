package baseball.Entity;

import java.util.List;

public class InputNumber {
    private static final int NUMBER_SIZE = 3;
    private static final char NOT_FIRST_NUMBER = 0;
    private List<Character> inputNumberList;

    public InputNumber(List<Character> inputNumberList) {
        validateNumberSize(inputNumberList);
        validateFirstNumber(inputNumberList);
        this.inputNumberList = inputNumberList;
    }

    public List<Character> getInputNumberList(){
        return inputNumberList;
    }

    private void validateNumberSize(List<Character> inputNumberList) {
        if (inputNumberList.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateFirstNumber(List<Character> inputNumberList) {
        if (inputNumberList.get(0) == NOT_FIRST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}

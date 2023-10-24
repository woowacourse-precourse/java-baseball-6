package baseball.model;


import baseball.constant.Constant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    private final List<Integer> number;

    public UserNumber(String input) {
        this.number = generateUserNumber(input);
    }

    private List<Integer> generateUserNumber(String input) {
        int[] inputList = convertStringToList(input);
        validateInput(inputList);
        return Arrays.stream(inputList).boxed().collect(Collectors.toList());

    }

    public List<Integer> getNumber() {
        return number;
    }

    private int[] convertStringToList(String input) {
        return input.chars()
                .map(num -> num - '0')
                .toArray();
    }

    private void validateInput(int[] inputList) {
        if (isDuplicateNumber(inputList) || isWrongFormatNumber(inputList) || isOverLengthNumber(inputList)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(int[] inputList) {
        return Arrays.stream(inputList)
                .distinct()
                .count() != Constant.RIGHT_NUMBER_LENGTH;
    }

    private boolean isWrongFormatNumber(int[] inputList) {
        return Arrays.stream(inputList)
                .anyMatch(num -> num < Constant.START_INCLUSIVE || num > Constant.END_INCLUSIVE);
    }

    private boolean isOverLengthNumber(int[] inputList) {
        return inputList.length != Constant.RIGHT_NUMBER_LENGTH;
    }

}

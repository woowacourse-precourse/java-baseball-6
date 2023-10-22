package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Exception.*;
import static baseball.Reader.readNumber;
import static baseball.Reader.readString;


public class Player {
    private List<Integer> userNumberList;

    public Player() {
        this.userNumberList = null;
    }

    public List<Integer> load3NumberList() {
        userNumberList = generateListOf3Number();
        return userNumberList;
    }

    private List<Integer> generateListOf3Number() {
        String inputString = readString();
        List<Integer> userNumberList = changeStringToList(inputString);

        return userNumberList;
    }

    private List<Integer> changeStringToList(String inputString) {
        String[] strings = inputString.split("");
        validateInputSize(strings);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            int number = Integer.parseInt(strings[i]);
            validateNumber(list, number);
            list.add(number);
        }
        return list;
    }

    public boolean chooseFinishGame() {
        int input = readNumber();
        validateFinishGameNumber(input);
        return input == 2;
    }

    private void validateInputSize(String[] strings) {
        if (strings.length != 3)
            throw new IllegalArgumentException(INVALID_SIZE_OF_INPUT.getMessage());
    }

    private void validateNumber(final List<Integer> list, final int number) {
        validateNull(number);
        validateNumberRange(number);
        validateDuplication(list, number);
    }

    private void validateNull(int number) {
        if (number == 0)
            throw new IllegalArgumentException(INVALID_TYPE_OF_INPUT.getMessage());
    }

    private void validateNumberRange(final int number) {
        if (number < 1 || number > 9)
            throw new IllegalArgumentException(INVALID_RANGE_OF_INPUT.getMessage());
    }

    private void validateDuplication(final List<Integer> randomNumberList, final int number) {
        if (randomNumberList.contains(number))
            throw new IllegalArgumentException(ALREADY_EXIST_NUMBER.getMessage());
    }

    private void validateFinishGameNumber(int input) {
        if (input != 1 && input != 2)
            throw new IllegalArgumentException(ONLY_1_OR_2.getMessage());
    }
}

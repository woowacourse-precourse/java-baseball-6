package baseball.model.generator;


import java.util.ArrayList;
import java.util.List;

import static baseball.Viewer.readNumber;
import static baseball.Viewer.readNumbers;


public class PlayerNumberGenerator extends NumberGenerator {
    static final String INVALID_SIZE_OF_INPUT = LIST_SIZE + "개의 숫자를 입력해주세요.";
    static final String INVALID_RANGE_OF_INPUT = "1~9 사이의 숫자를 입력해주세요.";
    static final String ALREADY_EXIST_NUMBER = "중복된 숫자가 있습니다.";
    static final String ONLY_1_OR_2 = "1 또는 2를 입력해주세요.";
    static final int RESTART_NUMBER = 1;
    static final int FINISH_NUMBER = 2;

    @Override
    public List<Integer> generateList() {
        return convertToList();
    }

    @Override
    protected List<Integer> convertToList() {
        String[] numbers = readNumbers().split("");
        validateInputSize(numbers);

        List<Integer> list = new ArrayList<>();

        for (String s : numbers) {
            int number = Integer.parseInt(s);
            validateNumber(list, number);
            list.add(number);
        }
        return list;
    }

    public boolean generateRestart() {
        int input = readNumber();
        if (input != RESTART_NUMBER && input != FINISH_NUMBER)
            throw new IllegalArgumentException(ONLY_1_OR_2);

        return input == RESTART_NUMBER;
    }

    protected void validateInputSize(String[] strings) {
        if (strings.length != LIST_SIZE)
            throw new IllegalArgumentException(INVALID_SIZE_OF_INPUT);
    }

    protected void validateNumber(final List<Integer> list, final int number) {
        validateNumberRange(number);
        validateDuplication(list, number);
    }

    protected void validateNumberRange(final int number) {
        if (number < NUMBER_MIN_RANGE || number > NUMBER_MAX_RANGE)
            throw new IllegalArgumentException(INVALID_RANGE_OF_INPUT);
    }

    protected void validateDuplication(final List<Integer> randomNumberList, final int number) {
        if (randomNumberList.contains(number))
            throw new IllegalArgumentException(ALREADY_EXIST_NUMBER);
    }
}

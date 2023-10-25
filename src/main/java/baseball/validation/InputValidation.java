package baseball.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.constant.MessageConst.*;
import static baseball.constant.NumberConst.*;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 사용자의 숫자 입력값에 대한 모든 검증을 진행한다.
     */
    public List<Integer> validateInputNum(String input) {
        validateInputLength(input);
        List<Integer> inputNums = changeStrToList(input);
        validateInputRange(inputNums);
        validateInputDuplicated(inputNums);

        return inputNums;
    }

    private List<Integer> changeStrToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 입력값의 길이가 3인지 검증한다.
     *
     * @param input 사용자의 입력값
     */
    public void validateInputLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    /**
     * 입력값이 1~9 사이의 숫자인지 검증한다.
     *
     * @param inputNums 사용자의 입력값의 각 자리를 쪼갠 리스트
     */
    public void validateInputRange(List<Integer> inputNums) {
        boolean checkRange = inputNums.stream()
                .allMatch(num -> FIRST_RANGE <= num && num <= LAST_RANGE);

        if (!checkRange) {
            throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MSG);
        }
    }

    /**
     * 입력값에 중복된 값이 존재하는지 검증한다.
     *
     * @param inputNums 사용자의 입력값의 각 자리를 쪼갠 리스트
     */
    public void validateInputDuplicated(List<Integer> inputNums) {
        if (inputNums.stream().distinct().count() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MSG);
        }
    }

    /**
     * 게임 진행을 제어하는 입력값에 대해 검증한다.
     *
     * @param input 사용자의 입력값
     */
    public void validateGameControlInput(int input) {
        if (input < RESTART_NUM || input > EXIT_NUM) {
            throw new IllegalArgumentException(GAME_CONTROL_EXCEPTION_MSG);
        }
    }
}
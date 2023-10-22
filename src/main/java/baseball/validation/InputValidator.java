package baseball.validation;

import baseball.constant.NumberConst;
import baseball.util.MessageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    // TODO: 입력받은 값의 유효성 검사
    private static final int VALIDATION_MAX_VALUE = NumberConst.MAX_INPUT_VALUE; // 입력 받은 값의 최대 값
    private static final int VALIDATION_MIN_VALUE = NumberConst.MIN_INPUT_VALUE; // 입력 받은 값의 최소 값
    private static final MessageUtil MESSAGE_UTIL = new MessageUtil(); // 메시지 출력 용도
    private static final int INPUT_NUM_LENGTH = NumberConst.EXPECTED_INPUT_LENGTH; // 입력할 수 있는 숫자의 최대 길이(3)


    /*
     * 유저에게 입력받은 값을 String 타입에서 List<Integer> 타입으로 변환 목적
     * 매개변수 : 입력 받은 값(문자열)
     * 반환 값 : 리스트(숫자)
     */
    private List<Integer> convertStringToList(String input) {
        // TODO: String 타입을 List 타입으로 변환하여 반환
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /*
     * 입력받은 숫자 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * 반환 값 : 입력 받은 문자열을 리스트로 변환하여 반환
     * 1. 입력받은 값이 숫자만 포함하고 있는지 확인
     * 2. 중복 숫자 있는지 확인 용도
     * 3. 3자리 초과 혹은 미만 값 입력
     * 유효성 검사 실패 시 IllegalArgumentException 발생
     */
    public List<Integer> validateInputValueAndReturnList(String inputValue) {
        // TODO: 입력받은 값 유효성 검사
        List<Integer> result;

        if (inputValue == null) {
            throw new IllegalArgumentException();
        }

        validateInputIsNumeric(inputValue); // 입력받은 값이 숫자만 있는지 확인

        result = convertStringToList(inputValue); // 숫자만 있을 경우 String 타입을 List<Integer> 타입으로 변경
        validateInputIsOneToNine(result); // 입력받은 값 중 1부터 9사이만 존재하는지 확인

        validateInputDuplicated(result); // 입력받은 값 중 중복 숫자가 있는지 확인
        validateInputLength(result); // 입력받은 값이 3글자 초과 혹은 미만인지 확인

        return result;
    }

    /*
     * 게임 종료 재시작 여부에 대하여 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * 1, 2 값이 아닌 경우 IllegalArgumentException 발생
     */
    public static void validationRestartAndStopValue(int inputValue) {
        // TODO: 게임 종료 이후 1,2 값만 입력하였는지 유효성 검사
        if (inputValue != 1 && inputValue != 2) {
            MESSAGE_UTIL.printInvalidGameControlInput();
            throw new IllegalArgumentException();
        }
    }

    /* *
     * 입력받은 숫자 중복 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * 중복 숫자가 있을 경우 IllegalArgumentException 발생
     */
    private static void validateInputDuplicated(List<Integer> inputValue) {
        // TODO: 입력받은 값 중복 숫자 유효성 검사
        if (inputValue.size() != inputValue.stream().distinct().count()) {
            MESSAGE_UTIL.printDuplicatedInputNumber();
            throw new IllegalArgumentException();
        }
    }

    /* *
     * 입력받은 숫자 size inputNumLength 인지 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * inputNumLength 자리 초과 혹은 미만 값 입력 시 IllegalArgumentException 발생
     */
    private static void validateInputLength(List<Integer> inputValue) {
        // TODO: 입력받은 값이 inputNumLength 와 같은지 유효성 검사
        if (inputValue.size() != INPUT_NUM_LENGTH) {
            MESSAGE_UTIL.printInvalidNumber();
            throw new IllegalArgumentException();
        }
    }


    /* *
     * 입력받은 값이 숫자인지 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * 입력받은 값이 숫자만 포함하지 않을 경우 IllegalArgumentException 발생
     */
    private static void validateInputIsNumeric(String inputValue) {
        // TODO: 입력받은 값이 숫자인지 유효성 검사
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException exception) {
            MESSAGE_UTIL.printInvalidNumeric();
            throw new IllegalArgumentException();
        }
    }

    /*
     * 입력받은 값이 1부터 9사이만 존재하는지 유효성 검사
     * 매개변수 : 유저에게 입력받은 값
     * 1부터 9사이 값이 아닌 경우 IllegalArgumentException 발생
     */
    private static void validateInputIsOneToNine(List<Integer> inputValue) {
        // TODO: 입력받은 값이 VALIDATION_MIN_VALUE 부터 VALIDATION_MAX_VALUE 사이 존재 하는지 유효성 검사
        if (!inputValue.stream().allMatch(element -> element >= VALIDATION_MIN_VALUE && element <= VALIDATION_MAX_VALUE)) {
            MESSAGE_UTIL.printInvalidRange();
            throw new IllegalArgumentException();
        }
    }
}

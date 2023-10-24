package baseball.util;

import baseball.constant.NumberConst;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    // TODO: 입력받은 값의 유효성 검사
    private Validator() {
    }

    /**
     * 유저에게 입력받은 값을 String 타입에서 List<Integer> 타입으로 변환 목적
     *
     * @param : 입력 받은 값(문자열)
     * @return : 리스트(숫자)
     */
    private static List<Integer> convertStringToList(String input) {
        // TODO: String 타입을 List 타입으로 변환하여 반환
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 입력받은 숫자 유효성 검사 1. 입력받은 값이 숫자만 포함하고 있는지 확인 2. 중복 숫자 있는지 확인 용도 3. inputNumLength 자리 초과 혹은 미만 값 입력
     *
     * @param : 유저에게 입력받은 값
     * @return : 입력 받은 문자열을 리스트로 변환하여 반환
     * @throws : 각 검사 단계에 따라 IllegalArgumentException 발생
     */
    public static List<Integer> validateInputValueAndReturnList(String inputValue) {
        // TODO: 입력받은 값 유효성 검사
        List<Integer> result;

        if (inputValue == null) {
            System.out.println("입력받은 값이 없습니다.");
            throw new IllegalArgumentException();
        }

        // 입력받은 값이 숫자만 있는지 확인
        validateInputIsNumeric(inputValue);

        // 숫자만 있을 경우 String 타입을 List<Integer> 타입으로 변경
        result = convertStringToList(inputValue);
        // 입력받은 값 중 validationMaxValue 부터 validationMinValue 사이만 존재하는지 확인
        validateInputIsOneToNine(result);

        // 입력받은 값 중 중복 숫자가 있는지 확인
        validateInputDuplicated(result);
        // 입력받은 값이 inputNumLength 자리 초과 혹은 미만인지 확인
        validateInputLength(result);

        return result;
    }

    /**
     * 게임 종료 재시작 여부에 대하여 유효성 검사
     *
     * @param : 유저에게 입력받은 값
     * @throws : NumberConst.RESTART_NUMBER, NumberConst.STOP_NUMBER 값이 아닌 경우 IllegalArgumentException 발생
     */
    public static void validationRestartAndStopValue(int inputValue) {
        // TODO: 게임 종료 이후 NumberConst.RESTART_NUMBER, NumberConst.STOP_NUMBER 값만 입력하였는지 유효성 검사
        if (inputValue != 1 && inputValue != 2) {
            MessageUtil.printInvalidGameControlInput();
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력받은 값이 숫자인지 유효성 검사
     *
     * @param : 유저에게 입력받은 값
     * @throws : 입력받은 값이 숫자만 포함하지 않을 경우 IllegalArgumentException 발생
     */
    public static void validateInputIsNumeric(String inputValue) {
        // TODO: 입력받은 값이 숫자인지 유효성 검사
        try {
            Integer.parseInt(inputValue); // 숫자 변환
        } catch (NumberFormatException exception) { // 숫자 변환 시 NumberFormatException 발생 : 숫자가 아닌 문자가 포함된 경우
            MessageUtil.printInvalidNumeric();
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력받은 숫자 중복 유효성 검사
     *
     * @param : 유저에게 입력받은 값
     * @throws : 중복 숫자가 있을 경우 IllegalArgumentException 발생
     */
    private static void validateInputDuplicated(List<Integer> inputValue) {
        // TODO: 입력받은 값 중복 숫자 유효성 검사
        if (inputValue.size() != inputValue.stream().distinct().count()) { // 전체 사이즈와 중복 제거된 사이즈 비교
            MessageUtil.printDuplicatedInputNumber();
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력받은 숫자 size inputNumLength 인지 유효성 검사
     *
     * @param : 유저에게 입력받은 값
     * @throws : inputNumLength 자리 초과 혹은 미만 값 입력 시 IllegalArgumentException 발생
     */
    private static void validateInputLength(List<Integer> inputValue) {
        // TODO: 입력받은 값이 inputNumLength 와 같은지 유효성 검사
        if (inputValue.size() != NumberConst.EXPECTED_INPUT_LENGTH) {
            MessageUtil.printInvalidNumber();
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력받은 값이 NumberConst.MIN_INPUT_VALUE 부터 NumberConst.MAX_INPUT_VALUE 사이만 존재하는지 유효성 검사
     *
     * @param : 유저에게 입력받은 값
     * @throws : NumberConst.MIN_INPUT_VALUE 부터 NumberConst.MAX_INPUT_VALUE 사이 값이 아닌 경우 IllegalArgumentException 발생
     */
    private static void validateInputIsOneToNine(List<Integer> inputValue) {
        // TODO: 입력받은 값이 VALIDATION_MIN_VALUE 부터 VALIDATION_MAX_VALUE 사이 존재 하는지 유효성 검사
        if (!inputValue.stream().allMatch(
                element -> element >= NumberConst.MIN_INPUT_VALUE && element <= NumberConst.MAX_INPUT_VALUE)) {
            MessageUtil.printInvalidRange();
            throw new IllegalArgumentException();
        }
    }
}

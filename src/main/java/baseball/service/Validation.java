package baseball.service;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력 값에 대하여 예외 처리 하는 클래스
 */
public class Validation {
    /**
     * 입력 숫자의 고정 크기
     */
    private static final int NUMBER_SIZE = 3;
    /**
     * 재시작 여부 값의 고정 크기
     */
    private static final int SIGNAL_SIZE = 1;

    /**
     * 사용자가 제시한 세자리 수 유효 한지 확인
     * <p>
     * 길이,범위,중복 여부에 대하여 확인
     *
     * @param num 사용자 입력값
     * @throws IllegalArgumentException 올바르지 않은 입력값
     */
    public void validate(String num) {
        try {
            validateLength(num);
            validateRange(num);
            validateDuplicate(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Console.close();
            throw e;
        }
    }

    /**
     * 재시작 여부에 대한 입력값 유효 한지 확인
     * <p>
     * 길이,범위에 대한 확인
     *
     * @param sign 사용자 입력값
     * @throws IllegalArgumentException 올바르지 않은 입력값
     */
    public void validateForRestart(String sign) {
        try {
            validateSignLength(sign);
            validateSignRange(sign);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Console.close();
            throw e;
        }
    }

    /**
     * 세자리인지 확인
     *
     * @param num 사용자 입력값
     * @throws IllegalArgumentException 세자리가 아닌 경우
     */
    public void validateLength(String num) {
        if (num.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 숫자를 입력하시오");
        }
    }

    /**
     * 한 자리인지 확인
     *
     * @param sign 사용자 입력값
     * @throws IllegalArgumentException 한 자리가 아닌 경우
     */
    public void validateSignLength(String sign) {
        if (sign.length() != SIGNAL_SIZE) {
            throw new IllegalArgumentException("재시작: 1, 종료: 2");
        }
    }

    /**
     * 해당 문자가 1~9 숫자를 나타 내는지 아스키 코드값 확인
     *
     * @param number 사용자 입력값의 각 자리값
     * @return 숫자를 나타 내면 true 이외면 false
     */
    public boolean notNum(char number) {
        if (number >= '1' && number <= '9') {
            return false;
        }
        return true;
    }

    /**
     * 모든 자리에 1~9 숫자를 입력 했는지 확인
     *
     * @param num 사용자 입력값
     * @throws IllegalArgumentException 숫자가 아닌 것을 입력한 경우
     */
    public void validateRange(String num) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (notNum(num.charAt(i))) {
                throw new IllegalArgumentException("각 자리에는 1~9 숫자만 입력하시오");
            }
        }
    }

    /**
     * 해당 문자가 1 아니면 2를 나타 내는지 아스키 코드값 확인
     *
     * @param sign 사용자 입력값
     * @return 1, 2 중 하나를 입력 받으면 true, 아니면 false
     */
    public boolean notSignal(char sign) {
        if (sign == '1' || sign == '2') {
            return false;
        }
        return true;
    }

    /**
     * 1 또는 2를 입력 받았는지 확인
     *
     * @param sign 사용자 입력값
     * @throws IllegalArgumentException 1 또는 2가 아닌 값을 받은 경우
     */
    public void validateSignRange(String sign) {
        if (notSignal(sign.charAt(0))) {
            throw new IllegalArgumentException("재시작: 1, 종료: 2");
        }

    }

    /**
     * 입력 받은 세자리 수 중 중복된 수가 있는지 확인
     * <p>
     * convertForDuplicate를 통해 입력값을 배열로 변환해서 확인.<br> 배열 각 요소의 값이 1보다 크면 중복된 값을 갖고 있음.
     *
     * @param num 사용자 입력값
     * @throws IllegalArgumentException 중복된 수가 있는 경우
     */
    public void validateDuplicate(String num) {
        int[] checkDuplicate = Converter.convertForDuplicate(num);
        for (int i = 0; i < checkDuplicate.length; i++) {
            if (checkDuplicate[i] > 1) {
                throw new IllegalArgumentException("중복된 숫자는 허용 되지 않습니다.");
            }
        }
    }


}

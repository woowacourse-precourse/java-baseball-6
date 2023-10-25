package baseball.view;


import baseball.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class ConsoleInput {

    static final String DIGITS_PATTERN = "^[1-9]+$";
    static final String ONE_OR_TWO_PATTERN  = "^[1-2]+$";

    /**
     * 사용자에게 숫자를 입력 받는 함수
     * @param len  입력받을 길이
     */
    public static List<Integer> readDigitNumber(int len) throws InvalidInputException {
        String input = readLine();

        if (validInput(input, len)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return convertStringToIntList(input);
    }

    /**
     * 입력 크기 검증, 입력 타입 검증
     */
    private static boolean validInput(String input, int length) {
        if (length == 1) {
            return input.length() != length || !input.matches(ONE_OR_TWO_PATTERN);
        }
        return input.length() != length || !input.matches(DIGITS_PATTERN) || validDuplicate(input);
    }

    /**
     * 중복 검증
     */
    private static boolean validDuplicate(String input) {
        return input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2);
    }


    /**
     * 문자열을 숫자 리스트로 반환
     */
    private static List<Integer> convertStringToIntList(String input) {
        List<Integer> list = new ArrayList<>(input.length());

        for (char c : input.toCharArray()) {
            list.add(c - '0');
        }
        return list;
    }

}

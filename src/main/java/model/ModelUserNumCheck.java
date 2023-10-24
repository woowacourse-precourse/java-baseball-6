package model;

import baseball.BaseBallGame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ModelUserNumCheck.java
 * <p>
 * 입력 받은 숫자 관련 처리 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ModelUserNumCheck {

    /**
     * 입력받은 문자열을 정답과 비교할 수 있게 변환
     *
     * @param str 사용자로부터 입력 받은 문자열
     * @return List<Integer> 타입으로 변환된 입력 숫자
     */
    public static List<Integer> changeToComparable(String str) {

        List<Integer> input = stringToListInt(str);

        inputErrorCheck(input);

        return input;

    }

    /**
     * 문자열을 List<Integer> 타입으로 변경
     *
     * @param str 사용자가 입력한 문자열
     * @return List<Integer>타입의 숫자
     */
    private static List<Integer> stringToListInt(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                BaseBallGame.errorThrow("notNum");
            }

            int digit = Character.getNumericValue(c);
            list.add(digit);
        }
        return list;
    }

    /**
     * 숫자 input에 대한 유효성 확인
     * <p>
     * 3자리 숫자인가 / 중복되지 않았는가 / 유효한 숫자인가
     *
     * @param input 사용자가 입력한 숫자
     */
    private static void inputErrorCheck(List<Integer> input) {

        if (input.size() != 3) {
            BaseBallGame.errorThrow("wrongLen");
        }

        Set<Integer> inputSet = new HashSet<>(input);
        if (inputSet.size() != 3) {
            BaseBallGame.errorThrow("duplicate");
        }

        for (Integer num : input) {
            if (num < 1 || num > 9) {
                BaseBallGame.errorThrow("invalidNum");
            }
        }

    }
}

/*
 * <pre>
 * Class : InputView
 * Comment: 사용자로부터 숫자를 입력받기
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           예외 처리 추가
 * 2023-10-23       손준형           매직넘버 상수 대체
 * </pre>
 *
 * @author 손준형
 * @version 1.0.1
 * @see
 */


package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InputView {
    public static final int NUMBER_SIZE = 3;

    public static List<Integer> userInput() {
        String input = Console.readLine();

        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNumber.add(input.charAt(i) - '0');
        }

        Set<Integer> duplicateTest = Set.copyOf(userNumber);
        if (duplicateTest.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        if (duplicateTest.contains(0)) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }
}

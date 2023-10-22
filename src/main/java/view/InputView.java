/*
 * <pre>
 * Class : InputView
 * Comment: 사용자로부터 숫자를 입력받기
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */


package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<Integer> userInput() {
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNumber.add(input.charAt(i) - '0');
        }

        return userNumber;
    }
}

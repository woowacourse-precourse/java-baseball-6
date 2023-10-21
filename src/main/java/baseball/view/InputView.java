package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<Integer> takeInput() {
        System.out.println("숫자를 입력해주세요");
        String value = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }
        return numbers;
    }
}

package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            return Arrays.stream(Console.readLine()
                            .split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}

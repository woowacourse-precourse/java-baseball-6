package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = "";
    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }
}

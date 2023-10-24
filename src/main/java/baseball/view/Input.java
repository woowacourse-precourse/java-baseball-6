package baseball.view;

import baseball.domain.ThreeNumbers;
import baseball.service.Exception;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final Exception exception = new Exception();

    public ThreeNumbers inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        exception.validateInputNumber(number);

        int[] numberArray = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numberList = Arrays.stream(numberArray).boxed().collect(Collectors.toList());
        return new ThreeNumbers(numberList);
    }
}

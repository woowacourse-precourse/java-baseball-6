package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NUBMER ="숫자를 입력해주세요 :";
    private static final String GAP ="";

    public static List<Integer> inputNumber(){
        System.out.print(INPUT_NUBMER);
        return Arrays.stream(Console.readLine().split(GAP))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

}

package baseball.domain.input;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView implements Input{
    @Override
    public int[] execute() {
        int[] numberArray = getNumberArray();
        Validator.validate(numberArray);
        return numberArray;
    }

    private static int[] getNumberArray() {
        System.out.print("숫자를 입력해주세요 : ");
        String nums = Console.readLine();
        return Arrays.stream(nums.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}

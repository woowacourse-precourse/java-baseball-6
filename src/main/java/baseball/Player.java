package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Player {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> createUserNum() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        BaseballNumber baseballNumber = new BaseballNumber(convertStringToList(input));
        return baseballNumber.getBaseballNum();
    }

    public List<Integer> convertStringToList(String input) {
        List<Integer> num;
        try {
            num = Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
        return num;
    }
}

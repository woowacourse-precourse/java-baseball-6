package baseball;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> userNum;

    public List<Integer> getUserNum() {
        return userNum;
    }

    public void createUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNum = convertStringToList(input);
        Number number = new Number(inputNum);
        number.validate();
        userNum = inputNum;
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

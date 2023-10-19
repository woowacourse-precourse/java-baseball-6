package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static List<Integer> inputList() {
        String input = Console.readLine();
        int inputLen = input.length();

        if (inputLen != 3) {
            throw new IllegalArgumentException("3자리를 입력해야 합니다.");
        }

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputLen; i++) {
            int inputNum = input.charAt(i) - '0';
            if (inputNum < 1 || inputNum > 9) {
                throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
            }

            if (inputList.contains(inputNum)) {
                throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
            }

            inputList.add(inputNum);
        }

        return inputList;
    }

    public static boolean inputOneOrTwo() {
        String input = Console.readLine();

        int inputLen = input.length();

        if (inputLen != 1) {
            throw new IllegalArgumentException("1자리를 입력해야 합니다.");
        }

        int inputNum = input.charAt(0);
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }

        return inputNum == 1;
    }
}

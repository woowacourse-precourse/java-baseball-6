package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    public List<Integer> receiveInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> result = convertStringToIntegerList(input);
        return result;
    }

    private List<Integer> convertStringToIntegerList(String input) {
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNum.add(input.charAt(i) - '0');
        }
        return inputNum;
    }
}

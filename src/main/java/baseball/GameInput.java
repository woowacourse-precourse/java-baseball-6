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

    private List<Integer> convertStringToIntegerList(String num) {
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            inputNum.add(num.charAt(i) - '0');
        }
        return inputNum;
    }
}

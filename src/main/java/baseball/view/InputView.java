package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<Integer> userInputNumber() {

        String userInput = Console.readLine();
        // TODO: 사용자 입력이 숫자만으로 이루어졌는지 검증
        String[] split = userInput.split("");
        Console.close();

        return changeUserInputToInt(split);
    }

    public int decideGameActionInput() {

        String userInput = Console.readLine();
        // TODO: 숫자인지 검증
        int decideGameAction = Integer.parseInt(userInput);
        // TODO: 1 or 2 인지 검증
        Console.close();

        return decideGameAction;
    }

    private List<Integer> changeUserInputToInt(String[] userInput) {

        // TODO: 3 자리 숫자만 입력했는지 검증 (userInput.length == 3 인지 검증)
        return Arrays.stream(userInput)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}

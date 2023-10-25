package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import baseball.feature.CheckInput;

public class User {

    private final CheckInput checkInput = new CheckInput();

    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkInput.checkInput(input);
        return modifyStringToList(input);
    }

    private List<Integer> modifyStringToList(String input) {
        return Arrays.stream(input.split("")).map(Integer::parseInt).toList();
    }

}

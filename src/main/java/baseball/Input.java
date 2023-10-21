package baseball;

import static baseball.validation.Validation.inputValidate;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<Integer> input() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        inputValidate(input);

        return stringToList(input);
    }

    public List<Integer> stringToList(String userNumber) {
        List<Integer> playerNumber = new ArrayList<>();

        for (String userNumbers : userNumber.split("")) {
            playerNumber.add(Integer.parseInt(userNumbers));
        }

        return playerNumber;
    }
}

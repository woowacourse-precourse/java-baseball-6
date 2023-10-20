package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Utils.stringToInt;
import static baseball.InputValidator.gameInputValidator;

public class UserInput {
    private List<Integer> userNum;

    UserInput() {
        this.userNum = new ArrayList<>();
    }

    public List<Integer> getUserNum() {
        return List.copyOf(userNum);
    }
    public void promptUserInput() {
        System.out.println("Enter 3 integer");
        String string = Console.readLine();
        gameInputValidator(string);
        userNum = stringToInt(string);
    }
}

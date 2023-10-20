package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Utils.stringToInt;

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
        try {
            String s = Console.readLine();
            //s validator
            userNum = stringToInt(s);
        } catch (IllegalArgumentException e) {
            System.out.println("Please.. sir, this is Wendy's");
        }
    }
}

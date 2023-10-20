package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private List<Integer> userNum;

    UserInput() {
        this.userNum = new ArrayList<>();
    }

    public List<Integer> getUserNum() {
        return List.copyOf(userNum);
    }
    public void storeUserInput() {
        System.out.println("Enter 3 integer");
        String a = Console.readLine();
        char[] tmp = a.toCharArray();
        for(char c: tmp) {
            userNum.add(Character.getNumericValue(c));
        }
    }
}

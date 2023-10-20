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
    public void promptUserInput() {
        System.out.println("Enter 3 integer");
        String s = Console.readLine();
        stringToInt(s);
    }
    public void stringToInt(String string) {
        char[] tmp = string.toCharArray();
        for(char c: tmp) {
            userNum.add(Character.getNumericValue(c));
        }
    }
}

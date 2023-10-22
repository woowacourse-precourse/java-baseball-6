package baseball.variable;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class PlayerNumber {
    private static final String INPUT = "숫자를 입력해주세요 : ";
    public List<Integer> playerNumber = new ArrayList<>();
    Validator validator = new Validator();

    public void getPlayerNumber() {
        System.out.print(INPUT);
        String tempString = Console.readLine();
        String[] str = splitString(tempString);
        for (String s : str) {
            int n = Integer.parseInt(s);
            playerNumber.add(n);
        }
        validator.isValid(playerNumber);
    }

    private String[] splitString(String str) {
        return str.split("");
    }
}

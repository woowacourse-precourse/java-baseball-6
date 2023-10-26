package baseball.variable;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private static final String INPUT = "숫자를 입력해주세요 : ";
    Validator validator = new Validator();

    public List<Integer> getPlayerNumber(List<Integer> number) {
        System.out.print(INPUT);
        String tempString = Console.readLine();
        String[] str = splitString(tempString);
        for (String s : str) {
            int n = Integer.parseInt(s);
            number.add(n);
        }
        validator.isValid(number);
        return number;
    }

    private String[] splitString(String str) {
        return str.split("");
    }
}

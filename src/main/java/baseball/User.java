package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Integer> userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> numbers = new ArrayList<>();
        String input = readLine();

        for (String num: input.split("")) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }
    public int userDecision() {
        int decision;
        String input = readLine();
        return decision = Integer.parseInt(input);
    }
}

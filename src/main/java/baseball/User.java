package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    public List<Integer> userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> numbers = new ArrayList<>();
        String input = readLine();
        int tempNum;
        checkExceptionMain(input);
        for (String num: input.split("")) {
            tempNum = Integer.parseInt(num);
            numbers.add(tempNum);
        }
        return numbers;
    }
    public int userDecision() {
        int decision;
        String input = readLine();
        checkExceptionDecision(input);
        decision = Integer.parseInt(input);
        return decision;
    }
    public void checkExceptionMain(String input) {
        isEmpty(input);
        checkLength(input);
        checkZero(input);
        checkDuplication(input);
    }
    public void checkExceptionDecision(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
    public void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    public void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    public void checkZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }
    public void checkDuplication(String input) {
        Set<Character> numSet = new HashSet<>();
        for (char num : input.toCharArray()) {
            numSet.add(num);
        }
        if (numSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}

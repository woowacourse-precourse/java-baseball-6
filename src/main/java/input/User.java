package input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String ZERO = "0";
    private static final int BASEBALL_COUNT = 3;

    public static List<Integer> userNumber() {
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
    public static String userDecision() {
        String input = readLine();
        checkExceptionDecision(input);
        return input;
    }
    private static void checkExceptionMain(String input) {
        isEmpty(input);
        checkLength(input);
        checkZero(input);
        checkDuplication(input);
    }
    private static void checkExceptionDecision(String input) {
        if (!(input.equals(RESTART) || input.equals(QUIT))) {
            throw new IllegalArgumentException();
        }
    }
    private static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkLength(String input) {
        if (input.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkZero(String input) {
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkDuplication(String input) {
        Set<Character> numSet = new HashSet<>();
        for (char num : input.toCharArray()) {
            numSet.add(num);
        }
        if (numSet.size() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}

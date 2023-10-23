package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final List<Integer> numberList = new ArrayList<>();

    public Player() {
    }

    public void enterNumber() {
        String input = Console.readLine();
        checkInputFormat(input);
        setNumberList(input);
    }

    private static void checkInputFormat(String input) {
        checkNumeric(input);
        checkDigitSize(input);
        checkDuplicate(input);
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDigitSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!set.add(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void setNumberList(String input) {
        String[] inputList = input.split("");
        numberList.clear();
        for (String number : inputList) {
            numberList.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}

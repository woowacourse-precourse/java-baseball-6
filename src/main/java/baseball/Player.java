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
        // 숫자형식 확인
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        // 3자릿수 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 중복된 숫자 확인
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

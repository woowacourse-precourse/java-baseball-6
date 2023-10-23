package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private static final int SIZE = 3;
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> setComputerNumber() {
        List<Integer> computerNumber;
        Set<Integer> set = new HashSet<>();
        while (set.size() < SIZE) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        computerNumber = new ArrayList<>(set);
        return computerNumber;
    }

    public List<Integer> setPlayerNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        List<Integer> playerNumber = stringToList(inputNumber());
        return playerNumber;
    }

    private List<Integer> stringToList(String num) {
        List<Integer> list = new ArrayList<>();
        for (char c : num.toCharArray()) {
            list.add(c - '0');
        }
        return list;
    }

    private String inputNumber() {
        String num = Console.readLine();
        if (!isValidNumber(num)) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    private boolean isValidNumber(String num) {
        if (num.length() != 3) {
            return false;
        }
        for (char c : num.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        if (num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) {
            return false;
        }
        return true;
    }
}
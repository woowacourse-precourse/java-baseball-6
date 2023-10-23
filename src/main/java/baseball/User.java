package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>();
    }

    public void inputNumber() {
        String input = Console.readLine();
        for (String s : input.split("")) {
            numbers.add(Integer.parseInt(s));
        }
    }
}

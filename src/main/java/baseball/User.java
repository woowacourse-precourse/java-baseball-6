package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        if (str.length() != 3) {
            throw new IllegalArgumentException("Invalid argument: " + str);
        }
        String[] strArr = str.split("");
        for (String s : strArr) {
            this.numbers.add(Integer.parseInt(s));
        }
    }
}

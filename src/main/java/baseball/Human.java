package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Human {
    private List<Integer> numbers;

    public void getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numString = Console.readLine();
        this.numbers = Arrays.stream(numString.split("")).map(Integer::parseInt).toList();
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Human {
    private List<Integer> numbers;

    public void getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numString = Console.readLine();
        List<Integer> numbers = Arrays.stream(numString.split("")).map(Integer::parseInt).toList();
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<Integer>(numbers);
        if(set.contains(0)) {
            throw new IllegalArgumentException();
        }
        if(set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}

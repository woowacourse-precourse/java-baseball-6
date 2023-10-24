package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pitcher {
    private List<Integer> numbers;
    private int maxSize;

    public Pitcher(int maxSize) {
        this.numbers = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        int randomNumber = Integer.parseInt(Console.readLine());
        Stack<Integer> split = splitNumbers(randomNumber);

        numbers.clear();
        while (numbers.size() < maxSize) {
            numbers.add(split.pop());
        }
    }

    public Stack<Integer> splitNumbers(int number) {
        Stack<Integer> split = new Stack<>();

        while (number != 0) {
            int digit = number % 10;
            split.push(digit);
            number /= 10;
        }

        return split;
    }
}

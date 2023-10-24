package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numString = Console.readLine();
        List<Integer> numbers = Arrays.stream(numString.split("")).map(Integer::parseInt).toList();
        validate(numbers);
        return numbers;
    }

    public static int inputNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int number = Integer.parseInt(Console.readLine());
        validate(number);
        return number;
    }

    private static void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.contains(0)) {
            throw new IllegalArgumentException();
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void validate(int number) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }
}

package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    public static List<Integer> createBaseballNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            createUnduplicatedNumbers(numbers);
        }
        return numbers;
    }

    private static void createUnduplicatedNumbers(List<Integer> numbers) {
        Integer number = Randoms.pickNumberInRange(1, 9);
        if(!numbers.contains(number)) {
 //           System.out.print(number);
            numbers.add(number);
        }
    }
}

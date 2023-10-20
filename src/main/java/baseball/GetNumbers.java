package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetNumbers {
    private static final int MAX_NUM_LENGTH = 3;
    public static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(computer);
        return computer;
    }

    public static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            if (!numbers.contains(Character.getNumericValue(ch))) {
                numbers.add(Character.getNumericValue(ch));
            }
        }

        BaseballException.numListSize(numbers, MAX_NUM_LENGTH);
        return numbers;
    }

}

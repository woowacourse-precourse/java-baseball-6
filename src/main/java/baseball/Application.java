package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NUM = 9;
    private static final int NUM_SIZE = 3;

    public static void main(String[] args) {

    }
    private static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, MAX_NUM);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUM_SIZE) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해 주세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private static int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < NUM_SIZE; i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }


}

package baseball;

import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumbers();
//        System.out.println(numbers);

        Judgement judgement = new Judgement();
        int count = judgement.correctCount(Arrays.asList(7, 8, 9), Arrays.asList(1, 2, 3));
        System.out.println(count);
    }

    public static List<Integer> selectComputerNums() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            set.add(random);
        }
        return new ArrayList<>(set);
    }

    public static List<Integer> getUserInput() {
        String numStr = Console.readLine();
        Set<Integer> set = new HashSet<>();
        List<Integer> userInput = new ArrayList<>();

        if (numStr.length() != 3) {
            throw new IllegalArgumentException("invalid number");
        }

        for (int i = 0; i < 3; i++) {
            if (1 <= numStr.charAt(i) - '0' && numStr.charAt(i) - '0' <= 9) {
                set.add(numStr.charAt(i) - '0');
            }
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("invalid number");
        }

        for (int i = 0; i < 3; i++) {
            userInput.add(numStr.charAt(i) - '0');
        }
        return userInput;
    }

    public static int[] compareNumber(List<Integer> computerNums, List<Integer> userInput) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNums.get(i) == userInput.get(i)) {
                result[1]++;
            } else if (computerNums.contains(userInput.get(i))) {
                result[0]++;
            }
        }
        return result;
    }


}

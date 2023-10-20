package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public List<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }
        return new ArrayList<>(numbers);
    }

    public boolean hasDuplicate(int[] guess) {
        Set<Integer> set = new HashSet<>();
        for (int num : guess) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱");
        }
        if (result[1] > 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "스트라이크");
        }
        System.out.println();
    }
}

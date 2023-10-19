package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private ArrayList<Integer> targetNumber = new ArrayList<>();

    Computer() {
        while (targetNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }

    ArrayList<Integer> GetNumber() {
        return targetNumber;
    }

    public int[] CompareNumber(int myNumber) {

        int[][] matrix = new int[3][3];
        int[] result = new int[3];
        int first = myNumber / 100;
        int second = (myNumber % 100) / 10;
        int third = (myNumber % 10);
        int index = 0;

        for (Integer e : GetNumber()) {
            if (e == first) {
                matrix[index][0] += 1;
                result[1] += 1;
            } else if (e == second) {
                matrix[index][1] += 1;
                result[1] += 1;
            } else if (e == third) {
                matrix[index][2] += 1;
                result[1] += 1;
            }
            index += 1;
        }

        for (int i = 0; i < 3; i++) {
            result[0] += matrix[i][i];
        }

        result[1] -= result[0];
        return result;
    }
}

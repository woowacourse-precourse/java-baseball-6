package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final ArrayList<Integer> targetNumber = new ArrayList<>();

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

    public String CompareNumber(int myNumber) {
        String Hint;
        int[][] matrix = new int[3][3];
        int[] result = new int[2];
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
        Hint = MakeStrike(result);
        return Hint;
    }

    public String MakeStrike(int[] arr) {
        System.out.println(GetNumber().toString());
        String strike = "스트라이크";
        String ball = "볼";
        String result = "";
        if (arr[1] != 0) {
            result = arr[1] + ball;
        }
        if (arr[0] != 0) {
            if (!result.isEmpty()) {
                result = result + " " + arr[0] + strike;
            } else {
                result = arr[0] + strike;
            }
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }
        return result;
    }
}


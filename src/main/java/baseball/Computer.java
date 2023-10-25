package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private ArrayList<Integer> targetNumber;

    ArrayList<Integer> GetNumber() {
        return targetNumber;
    }

    void PutNumber(ArrayList<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    void InitNumber() {
        ArrayList<Integer> arr = new ArrayList<>();

        while (arr.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!arr.contains(randomNumber)) {
                arr.add(randomNumber);
            }
        }
        PutNumber(arr);
    }


    String CompareNumber(int myNumber) {
        String Hint;
        int[][] matrix = new int[3][3];
        int[] result = new int[2];
        int[] myNumberArray = NumToArray(myNumber);
        int cnt = 0;
        int index;
        //1. targetNumber의 i 자리가 mynember의 j자리와 일치하는지 여부
        //2. 스트라이크,볼의 합구하기
        for (Integer e : GetNumber()) {
            index = FindIndex(e, myNumberArray);
            if (index != -1) {
                matrix[cnt][index] += 1;
                result[1] += 1;
            }
            cnt += 1;
        }
        // 스트라이크의 개수, 볼의 개수 담기
        result[0] = GetStrike(matrix);
        result[1] -= result[0];

        // 스트라이크와 볼의 개수를 이용해 hint 얻기
        Hint = MakeHint(result);
        return Hint;
    }

    int GetStrike(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    int[] NumToArray(int myNumber) {
        int first = myNumber / 100;
        int second = (myNumber % 100) / 10;
        int third = (myNumber % 10);
        return new int[]{first, second, third};
    }

    int FindIndex(int standard, int[] arr) {
        for (int i = 0; i < 3; i++) {
            if (standard == arr[i]) {
                return i;
            }
        }
        return -1;
    }


    String MakeHint(int[] arr) {
        String result = "";
        result = MakeBall(result, arr[1]);
        result = MakeStrike(result, arr[0]);
        result = MakeNothing(result);
        return result;
    }

    String MakeStrike(String result, int number) {
        if (number == 0) {
            return result;
        }

        if (!result.isEmpty()) {
            result = result + " " + number + "스트라이크";
        } else {
            result = number + "스트라이크";
        }
        return result;
    }

    String MakeBall(String result, int number) {
        if (number == 0) {
            return result;
        }
        return number + "볼";
    }

    String MakeNothing(String result) {
        if (result.isEmpty()) {
            return "낫싱";
        }
        return result;
    }
}


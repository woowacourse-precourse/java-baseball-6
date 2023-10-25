package baseball.control;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class ComputerControl {

    public int extractNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public ArrayList<Integer> checkNumber() {

        ArrayList<Integer> check = new ArrayList<>();

        while (check.size() < 3) {
            int rand = extractNumber();
            if (!check.contains(rand)) {
                check.add(rand);
            }
        }
        return check;
    }

    public String combineNumber(ArrayList<Integer> arr) {
        String result = "";
        result += arr.get(0);
        result += arr.get(1);
        result += arr.get(2);

        return result;
    }

    public String generateNumber() {
        ArrayList<Integer> arr = checkNumber();
        return combineNumber(arr);
    }
}

package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberController {

    public List<Integer> generateComputerNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> splitter(int num) {
        List<Integer> numList = new ArrayList<>(3);

        numList.add(num / 100);
        numList.add((num % 100) / 10);
        numList.add(num % 10);

        return numList;
    }

    public Map<String, Integer> compareNumberList(List<Integer> numList1, List<Integer> numList2) {
        Map<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);

        int strike = countStrike(numList1, numList2);
        int ball = countBall(numList1, numList2);

        if (strike == 0 && ball == 0) {
            return result;
        }
        result.replace("strike", strike);
        result.replace("ball", ball);
        return result;
    }

    public int countStrike(List<Integer> numList1, List<Integer> numList2) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (numList1.get(i) == numList2.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> numList1, List<Integer> numList2) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (numList1.get(i) != numList2.get(i) && numList2.contains(numList1.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}


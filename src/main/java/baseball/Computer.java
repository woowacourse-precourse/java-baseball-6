package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    public List<Integer> random() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public Map<String, Integer> count(List<Integer> random, String[] number) {

        Map<String, Integer> countMap = new HashMap<String, Integer>();

        countMap.put(Const.STRIKE, 0);
        countMap.put(Const.BALL, 0);

        for (int i = 0; i < random.size(); i++) {
            for (int j = 0; j < number.length; j++) {
                if (random.get(i) == Integer.parseInt(number[j]) && i == j) {
                    countMap.put(Const.STRIKE, countMap.get(Const.STRIKE) + 1);
                } else if (random.get(i) == Integer.parseInt(number[j])) {
                    countMap.put(Const.BALL, countMap.get(Const.BALL) + 1);
                }
            }
        }

        return countMap;
    }

    public String check(int ball, int strike) {

        String str = "";

        if (strike == 3) return str += strike + Const.STRIKE;
        if (ball == 0 && strike == 0) return str += Const.NOTHING;
        if (ball > 0) str += ball + Const.BALL;
        if (strike > 0) str += strike + Const.STRIKE;

        return str;
    }
}

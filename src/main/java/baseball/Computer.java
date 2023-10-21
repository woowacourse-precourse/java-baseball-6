package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {

    public List<Integer> generateRandomNumbers() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        return result;
    }

    public Boolean printHint(Map<String, Integer> guess) {
        int strike = guess.get("스트라이크");
        int ball = guess.get("볼");
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (guess.get("스트라이크").equals(3)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}

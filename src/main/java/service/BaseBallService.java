package service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import view.Input;


public class BaseBallService {

    Input input = new Input();

    private final List<Integer> computerNumber = new ArrayList<>();


    //랜덤넘버 생성
    public List<Integer> generateNumbers() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    //스트라이크, 볼, 낫싱 계산
    public List<String> calResult(int[] inputNumber) {

        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(inputNumber[i])) {
                strikes++;
            } else if (computerNumber.contains(inputNumber[i])) {
                balls++;
            }
        }

        List<String> results = new ArrayList<>();
        if (strikes > 0) {
            results.add(strikes + "스트라이크");
        }
        if (balls > 0) {
            results.add(balls + "볼");
        }
        if (strikes == 0 && balls == 0) {
            results.add("낫싱");
        }

        return results;

    }



}


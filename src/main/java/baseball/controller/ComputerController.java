package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerController {

    public List<Integer> getComputerRandomNumber() {

        return generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        int newRandomNumber;

        while(randomNumberList.size() < 3) {

            newRandomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumberList.contains(newRandomNumber)) {
                randomNumberList.add(newRandomNumber);
            }

        }

        return randomNumberList;
    }
}

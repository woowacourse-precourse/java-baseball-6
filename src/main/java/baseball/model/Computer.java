package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumberList;

    public List<Integer> getComputerRandomNumber() {
        randomNumberList = new ArrayList<>();

        return generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
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

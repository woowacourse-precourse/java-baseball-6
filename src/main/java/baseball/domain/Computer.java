package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {


    private static List<Integer> computerNumbers;

    public void generateNumber(){
        computerNumbers = getRandomNumbers();
    }

    public static List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}

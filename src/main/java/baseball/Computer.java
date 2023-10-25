package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNums = new ArrayList<>();

    public Computer(){
        this.randomNums = generateRandomNumber();
    }

    public List<Integer> getRandomNum() {
        return randomNums;
    }

    public List<Integer> generateRandomNumber(){
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

}
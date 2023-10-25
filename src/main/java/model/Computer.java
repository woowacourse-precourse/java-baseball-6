package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String randomNumber;

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String createRandomNumber(){
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList.toString().replaceAll("[^0-9]","");
    }

}

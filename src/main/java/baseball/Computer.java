package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {


    private List<Integer> computerNumber = new ArrayList<>();


    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber() {
        this.computerNumber = randomNumberGenerator();
    }


    public List<Integer> randomNumberGenerator() {

        List<Integer> generatedNumber=new ArrayList<>();

        while (generatedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumber.contains(randomNumber)) {
                generatedNumber.add(randomNumber);
              }
        }
        return generatedNumber;
    }
}

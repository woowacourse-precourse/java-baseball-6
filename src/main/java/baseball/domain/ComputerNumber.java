package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final static int numberSize = 3;
    private final static int minNumber = 1;
    private final static int maxNumber = 9;

    private List<Integer> computerNumber = new ArrayList<>();

    public ComputerNumber(){
        while (computerNumber.size() < numberSize) {
            int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!computerNumber.contains(randomNumber)) {
                this.computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber(){
        return computerNumber;
    }
}

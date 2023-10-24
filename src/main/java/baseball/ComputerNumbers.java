package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers{

    private List<Integer> computerNumbers;

    ComputerNumbers(){
        this.computerNumbers = createComputerRandomNumber();
    }

    public List<Integer> getComputerNumbers(){
        return computerNumbers;
    }

    private List<Integer> createComputerRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)){
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

}

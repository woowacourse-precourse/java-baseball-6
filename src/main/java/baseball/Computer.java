package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNum;

    public void selectComputerNum(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        setComputerNum(computerNumber);
    }

    public void setComputerNum(List<Integer> l){
        this.computerNum = l;
    }

    public List<Integer> getComputerNum(){
        return this.computerNum;
    }
}

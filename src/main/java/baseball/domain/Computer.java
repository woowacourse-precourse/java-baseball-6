package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Computer {
    private List<Integer> computerNumber;
    
    public void generateNumber() {
        List<Integer> computer = new ArrayList<>();
        
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        
        setNumber(computer);
    }

    private void setNumber(List<Integer> computer) {
        this.computerNumber = computer;
    }

    public List<Integer> getNumber() {
        return this.computerNumber;
    }
}


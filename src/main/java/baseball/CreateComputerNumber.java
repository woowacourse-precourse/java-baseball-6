package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateComputerNumber {
    private List<Integer> computer;

    private CreateComputerNumber(List<Integer> computer){
        this.computer = computer;
    }

    public static CreateComputerNumber createComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new CreateComputerNumber(computer);
    }

    public List<Integer> getComputer(){
        return computer;
    }

}

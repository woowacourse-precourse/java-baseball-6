package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// Computer가 랜덤 3자리 수 생성
public class ComputerNumber {
    private String computerNumber;

    public ComputerNumber(){
        generateNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    // 랜덤 3자리 수 생성
    public void generateNumber(){
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(Integer.toString(randomNumber));
            }
        }
        this.computerNumber = String.join("", computer);
    }



}

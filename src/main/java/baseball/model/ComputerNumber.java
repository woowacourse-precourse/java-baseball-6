package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
    // TODO: 상대방(컴퓨터) 랜덤값 생성
    private final String computerNum;
    public ComputerNumber(){
        this.computerNum = generateComputerNumber();
    }
    public String getComputerNumber(){
        return this.computerNum;
    }
    public String generateComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String computer_str = computer.toString().replaceAll("[^0-9]","");
        return computer_str;
    }
}

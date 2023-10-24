package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateRandomNum {
    private String computerNumber;
    public GenerateRandomNum(){
       makeRandomNumber();
    }
    public String getComputerNumber(){
        return computerNumber;
    }
    public String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return this.computerNumber=computer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}

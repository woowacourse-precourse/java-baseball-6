package baseball.model;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    //    랜덤 슷자 만들기
    public void setComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = computer.toString().replaceAll("[^0-9]","");
    }

}
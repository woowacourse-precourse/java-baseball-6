package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerNumber {
    private List<Integer> computer;

    public ComputerNumber() {
        this.computer = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            duplicateNumber(randomNumber);
        }
        return computer;
    }

    private void duplicateNumber(int randomNumber) {
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }

    public List<Integer> getComputer() {
        return computer;
    }

}

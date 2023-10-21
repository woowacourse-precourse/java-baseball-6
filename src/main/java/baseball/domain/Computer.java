package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    private List<Integer> computerNumber;

    public Computer() {
        computerNumber = new ArrayList<>();
    }

    public void createOne() {
        int number = Randoms.pickNumberInRange(1,9);
        if(!validDuplication(number)){
            computerNumber.add(number);
        }
    }

    public boolean validDuplication(int number) {
        if(computerNumber.contains(number)) return true;
        return false;
    }

    public void reset() {
        computerNumber.clear();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
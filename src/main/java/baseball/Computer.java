package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> computerNumber;

    public Computer() {
        this.computerNumber = new ArrayList<>();
        makeRandomComputerNumber();
        System.out.println("computerNumber = " + computerNumber);
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    private ArrayList<Integer> makeRandomComputerNumber() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}

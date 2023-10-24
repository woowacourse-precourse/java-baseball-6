package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private static Computer computer;
    List<Integer> number;

    private Computer() {
        number = new ArrayList<>();
    }

    public static Computer getComputer() {
        if (computer == null) {
            computer = new Computer();
        }

        return computer;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void createComputerNumber() {
        number.clear();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}

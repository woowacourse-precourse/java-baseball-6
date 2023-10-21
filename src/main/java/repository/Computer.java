package repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.TOTAL_CARDS;

public class Computer {
    private Computer() {
    }

    public static List<Integer> getComputerPicks() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < TOTAL_CARDS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}

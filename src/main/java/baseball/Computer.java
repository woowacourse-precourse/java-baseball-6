package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    private static final int COMPUTER_NUMBER_SIZE = 3;
    private static final int RANDOM_START_NUMBER = 1;
    private static final int RANDOM_END_NUMBER = 9;
    private final ArrayList<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        makeRandomComputerNumber();
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    private void makeRandomComputerNumber() {
        while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
            int randomNumber = generateUniqueNumber();
            computerNumber.add(randomNumber);
        }
    }

    private int generateUniqueNumber() {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
        } while (computerNumber.contains(randomNumber));
        return randomNumber;
    }

    public void resetComputerNumber() {
        this.computerNumber.clear();
        makeRandomComputerNumber();
    }
}

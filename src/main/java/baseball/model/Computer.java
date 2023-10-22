package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Character> computerNumber;

    public Computer() {
        this.computerNumber = createNumber();
    }

    private List<Character> createNumber() {
        List<Character> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomNumberChar = (char) (randomNumber + '0');
            if (!computerNumber.contains(randomNumberChar)) {
                computerNumber.add(randomNumberChar);
            }
        }
        return computerNumber;
    }

    public String getComputerNumber() {
        StringBuilder sb = new StringBuilder();
        for (char ch : computerNumber) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

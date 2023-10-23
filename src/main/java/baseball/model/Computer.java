package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Character> computerNumber;

    public Computer() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomNumberChar = (char) (randomNumber + '0');

            if (!computerNumber.contains(randomNumberChar)) {
                computerNumber.add(randomNumberChar);
            }
        }
    }

    public String getComputerNumber() {
        return computerNumber.stream()
                .map(String::valueOf)
                .reduce("", (s1, s2) -> s1 + s2);
    }
}

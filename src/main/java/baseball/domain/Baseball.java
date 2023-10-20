package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class Baseball {
    List<Integer> computerNumbers = new ArrayList<>();


    public List<Integer> generateRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public int findStrike(List<Integer> computerNumbers, List<Integer> userInput) {
        int strikeCount = 0;
        for (int i = 0; i < userInput.size(); i++) {
            int currentcomputerNumbers = computerNumbers.get(i);
            int currentUserNumber = userInput.get(i);

            if (currentcomputerNumbers == currentUserNumber) {
                strikeCount++;
            }

        }
        return strikeCount;
    }

}

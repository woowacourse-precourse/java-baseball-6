package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    public List<Integer> makeNumber() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            uniqueNumbers.add(randomNumber);
        }

        return new ArrayList<>(uniqueNumbers);
    }
}

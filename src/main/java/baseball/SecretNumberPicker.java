package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class SecretNumberPicker {
    public List<Integer> pickSecretNumbers() {
        List<Integer> secretNumbers = new ArrayList<>();

        while (secretNumbers.size() < GameConstants.NUMBER_LENGTH) {
            int newNumber = Randoms.pickNumberInRange(GameConstants.MIN_NUMBER, GameConstants.MAX_NUMBER);
            if (!secretNumbers.contains(newNumber)) {
                secretNumbers.add(newNumber);
            }
        }

        return secretNumbers;
    }
}

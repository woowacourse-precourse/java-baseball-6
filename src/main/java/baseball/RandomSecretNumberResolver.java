package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomSecretNumberResolver extends AbstractSecretNumberResolver {
    @Override
    protected List<Integer> resolveIntegers() {
        List<Integer> chosenIntegers = new ArrayList<>();
        while (chosenIntegers.size() < SecretNumber.SIZE) {
            Integer randomInteger = Randoms.pickNumberInRange(Digit.MIN_VALUE, Digit.MAX_VALUE);
            if (!chosenIntegers.contains(randomInteger)) {
                chosenIntegers.add(randomInteger);
            }
        }
        return chosenIntegers;
    }
}

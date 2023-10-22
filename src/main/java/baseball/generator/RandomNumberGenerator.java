package baseball.generator;

import baseball.enums.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> pitches = new ArrayList<>();
        while (pitches.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(GameConfig.MIN_NUMBER.getValue(),
                    GameConfig.MAX_NUMBER.getValue());
            if (!pitches.contains(randomNumber)) {
                pitches.add(randomNumber);
            }
        }
        return pitches;
    }
}

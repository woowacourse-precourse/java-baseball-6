package baseball.generator;

import baseball.enums.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomPitchGenerator implements PitchGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> pitches = new ArrayList<>();
        while (pitches.size() < 3) {
            int randomPitch = Randoms.pickNumberInRange(GameConfig.MIN_NUMBER.getValue(), GameConfig.MAX_NUMBER.getValue());
            if (!pitches.contains(randomPitch)) {
                pitches.add(randomPitch);
            }
        }
        return pitches;
    }
}

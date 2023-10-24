package baseball.infra;

import baseball.domain.BaseballNumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerBaseballNumberGenerator implements BaseballNumberGenerator {
    @Override
    public List<Integer> generateBaseballNumber(int length) {
        List<Integer> baseballNumber = new ArrayList<>();

        while (baseballNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }

        return baseballNumber;
    }
}

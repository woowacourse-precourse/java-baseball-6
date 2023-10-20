package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public Baseball buildRandomBaseball() {
//        return new Baseball(Randoms.pickUniqueNumbersInRange(1,9,3));
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Baseball(computer);
    }

    public Baseball buildBaseball(String numbers) {
        return new Baseball(numbers);
    }

}

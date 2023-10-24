package baseball.Service;

import baseball.Domain.Baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameService {

    public Baseball buildRandomBaseball() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }
        return new Baseball(set.stream().toList());
    }

    public Baseball buildBaseball(List<Integer> numbers) {
        return new Baseball(numbers);
    }

}

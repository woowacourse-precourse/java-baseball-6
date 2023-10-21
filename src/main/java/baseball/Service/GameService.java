package baseball.Service;

import baseball.Domain.Baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class GameService {

    public Baseball buildRandomBaseball() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computer.add(randomNumber);
        }
        return new Baseball(computer.stream().toList());
    }

    public Baseball buildBaseball(String numbers) {
        return new Baseball(numbers);
    }

}

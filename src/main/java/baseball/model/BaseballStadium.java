package baseball.model;

import baseball.domain.BaseballFlag;
import baseball.domain.ComputerNumbers;
import baseball.domain.RandomNumbers;
import baseball.domain.UserNumbers;

import java.util.List;

public class BaseballStadium {

    private RandomNumbers randomNumbers = new RandomNumbers();
    private ComputerNumbers computerNumbers;

    public List<BaseballFlag> userTry(String numbers) {
        List<Integer> userNumbers = UserNumbers.generate(numbers);
        return computerNumbers.match(userNumbers);
    }

    public void reset() {
        computerNumbers = new ComputerNumbers(randomNumbers.generate());
    }
}

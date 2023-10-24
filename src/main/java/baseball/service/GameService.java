package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameService {

    private InputValidator validator;
    private List<Integer> randomNumbers;

    public GameService() {
        this.validator = new InputValidator();
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public String validateInput(String userInput) {
        return "구현중";
    }
}

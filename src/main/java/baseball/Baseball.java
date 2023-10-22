package baseball;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstant.*;

public class Baseball {
    private final Validator validator = new Validator();
    public List<Integer> getPlayerNumber() {
        String input = Console.readLine();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }

    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

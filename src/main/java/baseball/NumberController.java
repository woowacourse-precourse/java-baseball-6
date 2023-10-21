package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberController {

    public List<Integer> randomComputerNumberGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> suggestedNumberConverter(int numberSuggestion) {
        List<Integer> suggestion = new ArrayList<>();
        suggestion.add(numberSuggestion / 100);
        suggestion.add(numberSuggestion / 10 % 10);
        suggestion.add(numberSuggestion % 10);
        return suggestion;
    }
}

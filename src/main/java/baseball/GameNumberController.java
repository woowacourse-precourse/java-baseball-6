package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumberController {

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
        validateNumberSuggestion(numberSuggestion);
        List<Integer> suggestion = new ArrayList<>();
        suggestion.add(numberSuggestion / 100);
        suggestion.add((numberSuggestion / 10) % 10);
        suggestion.add(numberSuggestion % 10);
        return suggestion;
    }

    public void validateNumberSuggestion(int numberSuggestion) {
        if (checkNumberSuggestionRange(numberSuggestion) || checkNumberSuggestionOverlap(numberSuggestion)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNumberSuggestionRange(int numberSuggestion) {
        return numberSuggestion > 999 || numberSuggestion < 100;
    }

    public boolean checkNumberSuggestionOverlap(int numberSuggestion) {
        int tripleDigit = numberSuggestion / 100;
        int doubleDigit = (numberSuggestion / 10) % 10;
        int singleDigit = numberSuggestion % 10;
        return (tripleDigit == doubleDigit) || (doubleDigit == singleDigit) || (tripleDigit == singleDigit);
    }
}

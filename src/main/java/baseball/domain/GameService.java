package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    static List<Integer> numbers = new ArrayList<>();
    static final int MAX_NUMBERS = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public List <Integer> generateNumbers(){
        while(numbers.size() < MAX_NUMBERS){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(isNotDuplicated(randomNumber)) numbers.add(randomNumber);
        }
        return numbers;
    }

    private boolean isNotDuplicated(int randomNumber) {
        return !numbers.contains(randomNumber);
    }

    public List<Integer> parseInputToList(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBERS; i++) {
            userNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return userNumbers;
    }
}

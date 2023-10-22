package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBallGame {
    private final List<Integer> computerRandomNumber;

    public BaseBallGame() {
        computerRandomNumber = RandomNumberGenerator.getUniqueRandomNumberSequence(3);
    }


    private void validateInputNumbers(String numberSequence){
        if (numberSequence.length() != 3){
            throw new IllegalArgumentException();
        }
        List<String> nonDuplicateNumbers = Arrays.stream(numberSequence.split(""))
                .distinct().toList();
        if (nonDuplicateNumbers.size() !=3){
            throw new IllegalArgumentException();
        }
    }
}

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



    private int countNumberOfStrike(final List<Integer> expectNumberSequence){
        int numberOfStrikes = 0;
        for (int i =0; i < computerRandomNumber.size(); i++){
            if (expectNumberSequence.get(i).equals(computerRandomNumber.get(i))){
                numberOfStrikes++;
            }
        }
        return numberOfStrikes;
    }


    private List<Integer> stringToListConverter(String numberSequence){
        try{
            numberSequence = numberSequence.replaceAll(" ", "");
            validateInputNumbers(numberSequence);
            return Arrays.stream(numberSequence.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
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

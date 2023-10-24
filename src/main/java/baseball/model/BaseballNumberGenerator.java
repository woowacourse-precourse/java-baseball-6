package baseball.model;

import baseball.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballNumberGenerator {
    public List<Integer> createRandomBaseballNumber(){
        List<Integer> randomBaseballNumber = new ArrayList<>();
        while (randomBaseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomBaseballNumber.contains(randomNumber)) {
                randomBaseballNumber.add(randomNumber);
            }
        }
        return randomBaseballNumber;

    }

    public List<Integer> createPlayerBaseballNumber(int playerNumber){
        List<Integer> playerNumberList = Arrays.stream(String.valueOf(playerNumber).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if(this.checkNumberRange(playerNumber) && this.checkNumberDigit(playerNumber) && this.checkDuplicateDigit(playerNumberList)){
            return playerNumberList;
        }

        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_EXCEPTION_MESSAGE);


    }

    private boolean checkDuplicateDigit(List<Integer> inputNumberList){

        if(inputNumberList.size() != inputNumberList.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private boolean checkNumberRange(int inputNumber){
        int [] inputNumberArray = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();

        for(int c : inputNumberArray){
            if(c==0){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE_EXCEPTION_MESSAGE);

            }
        }

        return true;

    }

    private boolean checkNumberDigit(int inputNumber){
        if(String.valueOf(inputNumber).length()!=3){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_DIGIT_EXCEPTION_MESSAGE);
        }
        return true;

    }
}

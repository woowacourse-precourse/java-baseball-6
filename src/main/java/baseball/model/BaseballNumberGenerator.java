package baseball.model;

import baseball.constant.BaseBallNumberConstant;
import baseball.constant.message.ExceptionMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballNumberGenerator {
    public List<Integer> createRandomBaseballNumber(){
        List<Integer> randomBaseballNumber = new ArrayList<>();
        while (randomBaseballNumber.size() < BaseBallNumberConstant.DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(BaseBallNumberConstant.START_RANGE, BaseBallNumberConstant.END_RANGE);
            if (!randomBaseballNumber.contains(randomNumber)) {
                randomBaseballNumber.add(randomNumber);
            }
        }
        return randomBaseballNumber;

    }

    public List<Integer> createPlayerBaseballNumber(int playerNumber){
        List<Integer> playerNumberList = Arrays.stream(String.valueOf(playerNumber).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if(this.checkNumberRange(playerNumberList) && this.checkNumberDigit(playerNumberList) && this.checkDuplicateDigit(playerNumberList)){
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

    private boolean checkNumberRange(List<Integer> inputNumberList){

        for(Integer c : inputNumberList){
            if(c==BaseBallNumberConstant.EXCLUDED_NUMBER){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE_EXCEPTION_MESSAGE);

            }
        }

        return true;

    }

    private boolean checkNumberDigit(List<Integer> inputNumberList){
        if(inputNumberList.size() !=BaseBallNumberConstant.DIGIT){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_DIGIT_EXCEPTION_MESSAGE);
        }
        return true;

    }
}

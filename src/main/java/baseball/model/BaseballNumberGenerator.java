package baseball.model;

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
        if(this.checkNumberRange(playerNumber) && this.checkNumberDigit(playerNumber)){
            return this.checkDuplicateDigit(playerNumber);
        }

        throw new IllegalArgumentException("입력한 숫자는 1부터 9까지 서로 다른 수로 이루어진 3자리가 아닙니다. ");


    }

    private List<Integer> checkDuplicateDigit(int inputNumber){
        List<Integer> inputNumberList = Arrays.stream(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if(inputNumberList.size() != inputNumberList.stream().distinct().count()){
            throw new IllegalArgumentException("입력한 숫자는 서로 다른 수로 이루어지지 않았습니다.");
        }
        return inputNumberList;
    }

    private boolean checkNumberRange(int inputNumber){
        int [] inputNumberArray = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();

        for(int c : inputNumberArray){
            if(c==0){
                throw new IllegalArgumentException("입력한 숫자가 1 ~ 9 사이의 수가 아닙니다.");

            }
        }

        return true;

    }

    private boolean checkNumberDigit(int inputNumber){
        if(String.valueOf(inputNumber).length()!=3){
            throw new IllegalArgumentException("입력한 숫자가 3 자릿수가 아닙니다.");
        }
        return true;

    }
}

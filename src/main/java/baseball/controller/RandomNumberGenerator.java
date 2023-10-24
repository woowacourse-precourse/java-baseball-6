package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int GENERATE_RANDOM_NUMBER = 3;

    public List<Integer> generateRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();

        for(int i = 0; i<GENERATE_RANDOM_NUMBER; i++){
            int randomNumber = generateRandomNumber(randomNumbers);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public Integer generateRandomNumber(List<Integer> randomNumbers){
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if(isValidNumber(randomNumber, randomNumbers)){
            return randomNumber;
        }else{
            return generateRandomNumber(randomNumbers);
        }
    }

    private boolean isValidNumber(int randomNumber, List<Integer> randomNumbers){
        if(!randomNumbers.contains(randomNumber)){
            return true;
        }
        else{
            throw new IllegalArgumentException("서로 다른 세 자리의 숫자만 입력 가능합니다.");
        }
    }
}

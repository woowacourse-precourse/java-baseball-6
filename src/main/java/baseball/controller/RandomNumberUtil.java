package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberUtil {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int BASEBALL_NUMBER_START = 1;
    private static final int BASEBALL_NUMBER_END = 9;

    public List<Integer> generateComputerNumber(){
        List<Integer> randomNumbers = new ArrayList<>();

        for(int i =0; i< BASEBALL_NUMBER_LENGTH;i++){
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }
        return randomNumbers;
    }

    private int generateRandomNumber(List<Integer> randomNumbers){
        while(true){
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_START,BASEBALL_NUMBER_END);
            if(isNotSame(randomNumbers,randomNumber)){
                return randomNumber;
            }
        }
    }

    private Boolean isNotSame(List<Integer> randomNumbers, int randomNumber){
        if(!randomNumbers.contains(randomNumber)){
            return true;
        }else{
            return false;
        }
    }


}

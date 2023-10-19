package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    public ArrayList<Integer> makeRandomNumbers(){
        ArrayList<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3){
            Integer randomNumber = pickRandomNumber();
            if(!isContainsSameNumber(computerNumbers, randomNumber)){
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    public Integer pickRandomNumber(){
        return Randoms.pickNumberInRange(1, 10);
    }

    public Boolean isContainsSameNumber(ArrayList<Integer> computerNumbers, Integer randomNumber){
        return computerNumbers.contains(randomNumber);
    }
}

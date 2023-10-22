package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    public ArrayList<String> makeRandomNumbers(){
        ArrayList<String> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3){
            String randomNumber = String.valueOf(pickRandomNumber());
            if(!isContainsSameNumber(computerNumbers, randomNumber)){
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    public Integer pickRandomNumber(){
        return Randoms.pickNumberInRange(1, 9);
    }

    public Boolean isContainsSameNumber(ArrayList<String> computerNumbers, String randomNumber){
        return computerNumbers.contains(randomNumber);
    }
}

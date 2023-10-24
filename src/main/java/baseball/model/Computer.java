package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import baseball.constant.ConsoleNumber;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> createNumber(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size()<3){
            int randomNumber=Randoms.pickNumberInRange(ConsoleNumber.FIRST_NUM,ConsoleNumber.LAST_NUM);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}

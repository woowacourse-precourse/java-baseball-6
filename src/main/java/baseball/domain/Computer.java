package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class Computer {

    private final List<BaseballNumber> computer;

    public Computer() {
        computer = new ArrayList<>();
        generateNumber();
    }

    public List<BaseballNumber> getComputerList() {

        return computer;
    }


    private void generateNumber(){
        Set<Integer> numberSet = new HashSet<>();
       while(numberSet.size() < 3){
           int randomNumber = Randoms.pickNumberInRange(1, 9);
           numberSet.add(randomNumber);
       }
       for(int n : numberSet){
           computer.add(new BaseballNumber(n));
       }
    }



}

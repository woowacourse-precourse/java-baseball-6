package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {

    private List<Integer> computer = new ArrayList<>();

    public BallNumber(){
        makeNumber();
    }

    public List<Integer> makeNumber(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            validContain(computer,randomNumber);
        }
        return computer;
    }

    private void validContain(List<Integer> number_list,int number){
        if (!number_list.contains(number)) {
            number_list.add(number);
        }
    }
}

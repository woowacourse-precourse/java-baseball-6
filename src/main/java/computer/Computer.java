package computer;

import baseball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int BALLS_SIZE = 3;
    private List<Integer> computerNumber = new ArrayList<>();

    public Balls makeComputerNumber(){
        while (computerNumber.size() < BALLS_SIZE) {
            addNonDuplicationNumber(computerNumber,Randoms.pickNumberInRange(1, 9));
        }
        Balls computer = new Balls(computerNumber);
        return computer;
    }

    private void addNonDuplicationNumber(List<Integer> list, int number){
        if(!list.contains(number)){
            list.add(number);
        }
    }
}

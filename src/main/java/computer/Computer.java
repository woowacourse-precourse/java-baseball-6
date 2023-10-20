package computer;


import baseball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {

    private static final int BALLS_SIZE=3;
    List<Integer> computer=new ArrayList<>();
    private Balls balls;

    public Balls makeComputerNumber(){
        while (computer.size() < BALLS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        balls=new Balls(computer);
        return balls;
    }







}

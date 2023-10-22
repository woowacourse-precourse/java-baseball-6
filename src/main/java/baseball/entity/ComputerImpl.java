package baseball.entity;

import baseball.View;
import baseball.impl.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements Computer {
    String target;
    @Override
    public void MakeRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        target = computer.get(0) + String.valueOf(computer.get(1)) + computer.get(2);
    }

    @Override
    public boolean CountScore(String answer) {
        long Ball = 0L;
        long Strike = 0L;

        String[] iter = answer.split("");
        for(String i:iter){
            if(!target.contains(i)){
                continue;
            }
            if(target.indexOf(i)==answer.indexOf(i)){
                Strike=Strike+1L;
            }
            if(target.indexOf(i)!=answer.indexOf(i)){
                Ball=Ball+1L;
            }
        }
        return View.OutputMessage(Ball,Strike);
    }
}

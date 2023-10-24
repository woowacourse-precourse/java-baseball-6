package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> makeAnswer(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    BallCount calBallCount(List<Integer> computer, List<Integer> user){

        int strike = 0;
        int ball = 0;

        for(int i = 0; i<computer.size(); i++){
            if(! computer.contains(user.get(i))) continue;
            if(computer.get(i) == user.get(i)) strike++;
            else ball++;
        }

        BallCount ballCount = new BallCount(strike, ball);
        return ballCount;
    }


}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computer;

    public List<Integer> Computer(){
        return this.computer = makeAnswer();
    }

    private List<Integer> makeAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public BallCount calBallCount(List<Integer> computer, List<Integer> user){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i<computer.size(); i++){
            int currentUser = user.get(i);
            int currentComputer = computer.get(i);
            if(! computer.contains(currentUser)) continue;
            if(currentComputer == currentUser) strike++;
            else if(currentComputer != currentUser) ball++;
        }
        BallCount ballCount = new BallCount(strike, ball);
        return ballCount;
    }
}

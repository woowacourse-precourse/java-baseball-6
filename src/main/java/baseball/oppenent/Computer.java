package baseball.oppenent;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> randomNumber = new ArrayList<>();

    private void Comparator(){
    }

    public Computer(final int NUMCONDITION){
        while (randomNumber.size() < NUMCONDITION){
            int pickedNumber = Randoms.pickNumberInRange(1,9);
            if(!this.randomNumber.contains(pickedNumber)){
                this.randomNumber.add(pickedNumber);
            }
        }
    }

    public Map<String,Integer> getHint(List<Integer> userAnswer) {
        Map<String, Integer> hint = new HashMap<>();
        hint.put("strike", getStrike(userAnswer));
        hint.put("ball", getBall(userAnswer));
        return hint;
    }

    private int getStrike(List<Integer> answer){
        int strike = 0;
        for (int i = 0; i< this.randomNumber.size(); i++){
            if(this.randomNumber.get(i) == answer.get(i)){
                strike++;
            }
        }
        return strike;
    }

    private int getBall(List<Integer> userAnswer){
        int ball = 0;
        for(int i = 0; i<this.randomNumber.size(); i++){
            if(randomNumber.get(i) != userAnswer.get(i)
            && this.randomNumber.contains(userAnswer.get(i))){
                ball++;
            }
        }
        return ball;
    }

}

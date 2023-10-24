package baseball.model;

import java.util.List;

public class GameStatusNumber {
    public int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers){
        int strike=0;
        for(int i=0;i< userNumbers.size();i++){
            if(userNumbers.get(i).equals(computerNumbers.get(i))){
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> userNumbers, List<Integer> computerNumbers){
        int ball=0;
        for(int i=0;i<userNumbers.size();i++){
            if (userNumbers.contains(computerNumbers.get(i)) && !userNumbers.get(i).equals(computerNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}

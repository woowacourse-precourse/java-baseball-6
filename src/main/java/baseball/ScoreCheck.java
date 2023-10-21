package baseball;

import java.util.List;

public class ScoreCheck {
    public int totalScore(List<Integer> user, List<Integer> computer){
        int sameNum = 0;
        for(int i= 0; i < user.size(); i++){
            if(computer.contains(user.get(i))){
                sameNum += 1;
            }
        }
        return sameNum;
    }

    public int strikeCount(List<Integer> user, List<Integer> computer){
        int strike = 0;
        for(int i = 0; i < user.size(); i++){
            if(user.get(i) == computer.get(i)){
                strike += 1;
            }
        }
        return strike;
    }

    public int ballCount(List<Integer> user, List<Integer> computer){
        int ball = 0;
        for(int i = 0; i < user.size(); i++){
            for(int j = 0; j < computer.size(); j++){
                if(i != j && user.get(i) == computer.get(i)){
                    ball += 1;
                }
            }
        }
        return ball;
    }


}

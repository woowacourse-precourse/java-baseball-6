package baseball;

import java.util.List;

public class PlayGame {
    public int totalScore(List<UserBalls> user, List<ComputerBalls> computer){
        int result = 0;
        for(int i= 0; i < user.size(); i++){
            if(computer.contains(user.get(i))){
                result += 1;
            }
        }
        return result;
    }


}

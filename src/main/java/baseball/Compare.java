package baseball;

import java.util.List;

public class Compare {
    public int totalBall(List<Integer> computer, List<Integer> player){
        int result = 0;
        for(int i=0;i < player.size();i++){
            if(computer.contains(player.get(i))){
                result ++;
            }
        }
        return result;
    }
    public int countStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i=0;i < player.size();i++){
            if(computer.get(i) == player.get(i)){
                strike++;
            }
        }

        return strike;
    }
}

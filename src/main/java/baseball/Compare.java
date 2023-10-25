package baseball;

import java.util.List;

public class Compare {
    public int howMany(List<Integer> computer,List<Integer> player){ // ball과 strike 개수
        int result = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                result += 1;
            }
        }
        return  result;
    }

    public int countStrike(List<Integer> computer, List<Integer> player){ //strike 개수
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}

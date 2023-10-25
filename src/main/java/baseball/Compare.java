package baseball;

import java.util.List;

public class Compare {
    public int countTotal(List<Integer> computer, List<Integer> player){
        int total = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                total += 1;
            }
        }
        return total;
    }

    public int countStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}

package baseball;

import java.util.List;

public class Compare {
    public int CountEqualNumber(List<Integer> computer, List<Integer> player){
        int equal = 0;
        for(int i =0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                equal += 1;
            }
        }
        return equal;
    }

    public int CountStrikeNumber(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i=0;i<player.size();i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }
}

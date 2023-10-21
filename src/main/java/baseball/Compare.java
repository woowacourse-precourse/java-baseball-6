package baseball;

import java.util.List;

public class Compare {
    public int CountEqualNumber(List<Integer> computer, List<Integer> player){
        // 동일한 숫자를 비교하여 계산하고 equal에 저장한다.
        int equal = 0;
        for(int i =0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                equal += 1;
            }
        }
        return equal;
    }

    public int CountStrikeNumber(List<Integer> computer, List<Integer> player){
        // 전체 스트라이크의 갯수를 계산하고 strike에 저장한다.
        int strike = 0;
        for(int i=0;i<player.size();i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }
}

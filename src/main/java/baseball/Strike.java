package baseball;

import java.util.ArrayList;
import java.util.List;

public class Strike {

    /**
     * strike의 수를 반환 하는 메서드 입니다.
     */
    public int strikeCount(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        return checkStrike(computer, player);
    }

    /**
     * strike의 갯수를 확인 해주는 메서드 입니다.
     */
    public int checkStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;

        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike++;
            }
        }

        return strike;
    }
}

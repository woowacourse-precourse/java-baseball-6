package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Defender {
    private List<Integer> defendNums;

    private Defender(List<Integer> randomDefenderNums) {
        this.defendNums = randomDefenderNums;
    }

    public List<Integer> getDefendNums() {
        return defendNums;
    }

    public static Defender create(){
        List<Integer> randomDefenderNums = new ArrayList();
        while(randomDefenderNums.size()<3){
            int randomNum = Randoms.pickNumberInRange(1,9);
            if(!randomDefenderNums.contains(randomNum)){
                randomDefenderNums.add(randomNum);
            }
        }
        return new Defender(randomDefenderNums);
    }
}

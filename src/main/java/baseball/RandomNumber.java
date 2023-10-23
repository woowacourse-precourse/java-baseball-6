package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public int randomNum() {
        return Randoms.pickNumberInRange(1,9);
    }

    public int[] createRanArr(){
        int[] ranArr = new int[3];

        for(int i = 0;i<ranArr.length;i++){
            ranArr[i] = randomNum();
        }
        return ranArr;
    }
}

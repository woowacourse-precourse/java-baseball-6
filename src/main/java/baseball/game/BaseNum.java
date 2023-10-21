package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseNum {

    private int[] baseNum;

    public int[] createRandomBaseNum(int startInclusive, int endInclusive, int count){
        baseNum = new int[count];
        for(int i=0; i<count; i++){
            int randomNum = resRandomNum(startInclusive, endInclusive, i);
            baseNum[i] = randomNum;
        }
        return baseNum;
    }

    public int resRandomNum(int startInclusive, int endInclusive, int index){
        int randomNum = createRandomNum(startInclusive, endInclusive);
        if(validateRandomNum(randomNum, index)){
            return randomNum;
        } else {
            return resRandomNum(startInclusive, endInclusive, index);
        }
    }

    // 검증 - 다른 숫자가 나와야 된다.
    public boolean validateRandomNum(int randomNum, int index){
        for(int i=0; i<index; i++){
            if(baseNum[i] == randomNum) return false;
        }
        return true;
    }

    public int createRandomNum(int startInclusive, int endInclusive){
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

}

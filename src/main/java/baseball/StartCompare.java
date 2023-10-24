package baseball;

import java.util.List;

public class StartCompare {

    /**
     * Strike, ball에 관계없이 일치 하는 숫자의 갯수만 알려주는 메서드 입니다.
     */
    public int countDigit(List<Integer> computer, List<Integer> player){

        int count = 0;

        for(int i : player){
            if(computer.contains(i)){
                count++;
            }
        }

        return count;
    }
}

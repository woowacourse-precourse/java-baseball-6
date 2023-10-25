package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNums {
    private int[] computerNums = {0, 0, 0};
    private boolean[] computerNumsBucket = {false, false, false, false, false, false, false, false, false, false};

    public ComputerNums () {
        for (int i = 0; i < computerNums.length; i++) {
            computerNums[i] = pickNumberInRange(1, 9);
            if(!computerNumsBucket[computerNums[i]]) computerNumsBucket[computerNums[i]]=true;
            else i--;
        }
    }

    public int computerNumsLength(){
        return computerNums.length;
    }
    public boolean getComputerNumsBucket(int i){
        return computerNumsBucket[i];
    }
    public int getComputerNums(int i){
        return computerNums[i];
    }
}
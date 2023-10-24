package baseball;

import camp.nextstep.edu.missionutils.Randoms;
public class ComputerNumGenerator {
    public static int[] ComNumGen(){
        int[] comNum = new int[3];
        comNum[0] = Randoms.pickNumberInRange(1,9);
        for(int i=1; i<3; i++){
            comNum[i] = Randoms.pickNumberInRange(1,9);
            if(comNum[i-1] == comNum[i] || comNum[0] == comNum[2])i--;
        }
        return comNum;
    }
}
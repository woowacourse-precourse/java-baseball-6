package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    int[] randomNumbers;
    Computer(){
        randomNumbers = new int[3];
    }
    public int[] initiate(){
        boolean[] duplicateCheck = new boolean[10];
        for(int i = 0; i < 3; i++){
            int num = Randoms.pickNumberInRange(1, 9);
            if(duplicateCheck[num]){
                i--;
                continue;
            }
            duplicateCheck[num] = true;
            randomNumbers[i] = num;
        }
        return randomNumbers;
    }
}

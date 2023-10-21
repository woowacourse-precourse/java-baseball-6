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
            if(checkDuplicated(duplicateCheck, num)){
                i--;
                continue;
            }
            randomNumbers[i] = num;
        }
        return randomNumbers;
    }
    private boolean checkDuplicated(boolean[] duplicateCheck, int num){
        if(duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }
    public int[] judge(int[] input){
        int[] judgeResult = new int[2];
        for(int user = 0; user < 3; user++){
            for(int com = 0; com < 3; com++){
                if(input[user] == randomNumbers[com]){
                    if(user == com) judgeResult[1]++;
                    else judgeResult[0]++;
                }
            }
        }
        return judgeResult;
    }
}

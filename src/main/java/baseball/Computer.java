package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    int[] computerNumbers;
    Computer(){
        computerNumbers = new int[3];
    }
    public int[] initComputerNumbers(){
        boolean[] visitedNumberArray = new boolean[10];
        int computerNumberIndex = 0;
        while(computerNumberIndex < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(checkDuplicated(visitedNumberArray, randomNumber)) continue;
            computerNumbers[computerNumberIndex++] = randomNumber;
        }
        return computerNumbers;
    }
    private boolean checkDuplicated(boolean[] duplicateCheck, int num){
        if(duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }
    public int[] getJudgeResult(int[] input){
        int[] judgeResult = new int[2];
        for(int user = 0; user < 3; user++){
            for(int com = 0; com < 3; com++){
                if(input[user] == computerNumbers[com]){
                    if(user == com) judgeResult[1]++;
                    else judgeResult[0]++;
                }
            }
        }
        return judgeResult;
    }
}

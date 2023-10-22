package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private int[] computerNumbers;
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
    public Judgement getJudgement(int[] userInput){
        return new Judgement(userInput, computerNumbers);
    }
}

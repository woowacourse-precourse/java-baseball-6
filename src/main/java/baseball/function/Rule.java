package baseball.function;
import baseball.value.GameCount;
import baseball.value.ResultNum;

public class Rule {

    GameCount gameCount;

    public void checkMatches(){
        ResultNum resultNum = new ResultNum();
        for (int i = 0; i < 3; i++){
            compareNumber(resultNum.getComputerNumber(), resultNum.getUserNumber(), i);
            System.out.println("qqq");
        }
    }

    public void compareNumber(int[] computerNumber, int[] userNumber, int userIndex){
        int isNon = -1;
        for (int j = 0; j < 3 ; j++){
            if(computerNumber[j] == userNumber[userIndex]){
                isNon = j;
                break;
            }
        }
        addCount(isNon, userIndex);
    }

    public void addCount(int isNon, int userIndex){
        if (isNon != -1 && isNon == userIndex){
            gameCount.strike();
        }
        if (isNon != -1 && isNon != userIndex){
            gameCount.ball();
        }
    }
}

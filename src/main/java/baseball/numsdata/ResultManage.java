package baseball.numsdata;

import java.util.List;

public class ResultManage {
    private static final int MAX_SIZE = 3;
    private int ball;
    private int strike;

    public void gameSetResult(List<Integer> userInput, List<Integer> randomNum) {
        int[] checkScore = new int[MAX_SIZE];

        for(int computerNum = 0; computerNum < 3; computerNum++){
            for(int userNum = 0; userNum < 3; userNum++){
                if(checkScore[userNum] == 2 ) continue;
                if(randomNum.get(computerNum).equals(userInput.get(userNum)) && computerNum == userNum) {
                    checkScore[computerNum] = 2;
                    break;
                }
                else if(randomNum.get(computerNum).equals(userInput.get(userNum))){
                    checkScore[computerNum] = 1;
                    break;
                }
            }
        }

        for(int i = 0; i < 3; i++){
            if(checkScore[i] == 1){
                ball++;
            }
            else if(checkScore[i] == 2){
                strike++;
            }
        }
    }

    public int getBall(){
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}

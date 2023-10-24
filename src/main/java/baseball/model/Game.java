package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> computerNumber;
    private boolean success;
    public void result(List<Integer> user, ResultRecord resultRecord){
        int ballCount= 0, strikeCount = 0;

        for(int i=0;i<3;i++) {
            if(computerNumber.get(i).equals(user.get(i))) {
                strikeCount++;
            }else if(computerNumber.contains(user.get(i))){
                ballCount++;
            }
        }
        resultRecord.setStrikeCount(strikeCount);
        resultRecord.setBallCount(ballCount);
        if(strikeCount==3)
            success = true;
        else
            success = false;
    }
    public Game(){
        setComputerNumber();
        success = false;
    }

    void setComputerNumber(){
        computerNumber = new ArrayList<>();
        while(computerNumber.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
    }
    public boolean getSuccess(){
        return success;
    }
}

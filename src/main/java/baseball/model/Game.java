package baseball.model;

import java.util.List;

public class Game {
    public ResultRecord result(List<Integer> user, List<Integer> computer){
        ResultRecord resultRecord = new ResultRecord();
        int ballCount= 0, strikeCount = 0;

        for(int i=0;i<3;i++) {
            if(computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }else if(computer.contains(user.get(i))){
                ballCount++;
            }
        }
        resultRecord.setStrikeCount(strikeCount);
        resultRecord.setBallCount(ballCount);
        return resultRecord;
    }
}

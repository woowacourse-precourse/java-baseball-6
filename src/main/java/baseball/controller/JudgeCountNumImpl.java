package baseball.controller;

import baseball.model.CountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;

import java.util.List;

public class JudgeCountNumImpl implements JudgeCountNum {


    public CountNum getJudgeCountNum(UserNum userNum, TargetNum targetNum){
        List<Integer> userNumArray=userNum.getUserNumArray();
        List<Integer> targetNumArray=targetNum.getTargetNumArray();

        Integer strike=0;
        Integer ball=0;

        for(int i=0;i<3;i++){
            for(int j=i;j<3;j++){
                if(userNumArray.get(i)==targetNumArray.get(j)){
                    if(i!=j){
                        ball++;
                    }
                    if(i==j){
                        strike++;
                    }
                }
            }
        }
        CountNum countNum=new CountNum(strike,ball);

        return countNum;

    }

}

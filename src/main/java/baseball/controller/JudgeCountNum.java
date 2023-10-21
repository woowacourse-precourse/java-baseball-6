package baseball.controller;

import baseball.model.CountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;

import java.util.List;

public class JudgeCountNum {

    private CountNum countNum;

    public JudgeCountNum(UserNum userNum, TargetNum targetNum){
        List<Integer> userNumArray=userNum.getUserNumArray();
        List<Integer> targetNumArray=targetNum.getTargetNumArray();

        Integer strike=0;
        Integer ball=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
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
        this.countNum=new CountNum(strike,ball);

    }

    public CountNum getCountNum() {
        return countNum;
    }
}

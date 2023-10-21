package baseball.controller;

import baseball.model.CountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;
import camp.nextstep.edu.missionutils.Console;
public class BaseballGame {

    public void baseballGame(){
        GenerateTargetNum generateTargetNum = new GenerateTargetNum();
        TargetNum targetNum = generateTargetNum.getTargetNum();
        String s;
        while(true){
            s=Console.readLine();
            ValidUserNum validUserNum = new ValidUserNum(s);
            UserNum userNum=validUserNum.getUserNum();

            JudgeCountNum judgeCountNum = new JudgeCountNum(userNum,targetNum);
            CountNum countNum = judgeCountNum.getCountNum();
            int strike = countNum.getStrikeNum();
            int ball = countNum.getBallNum();

            if(strike==3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if(strike==0 && ball==0){
                System.out.println("낫싱");
            }
            else if(strike==0){
                System.out.println(ball+"볼");
            }
            else if(ball==0){
                System.out.println(strike+"스트라이크");
            }
            else{
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }

        }
    }


}

package baseball.view;

import baseball.controller.GenerateTargetNum;
import baseball.controller.JudgeCountNum;
import baseball.controller.ValidUserNum;
import baseball.model.CountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;
import camp.nextstep.edu.missionutils.Console;
public class BaseballGameImpl implements BaseballGame {

    private final GenerateTargetNum generateTargetNum;
    private final ValidUserNum validUserNum;
    private final JudgeCountNum judgeCountNum;

    public BaseballGameImpl(GenerateTargetNum generateTargetNum,ValidUserNum validUserNum, JudgeCountNum judgeCountNum){
        this.generateTargetNum=generateTargetNum;
        this.validUserNum=validUserNum;
        this.judgeCountNum=judgeCountNum;
    }
    public void playBaseballGame(){
        TargetNum targetNum = generateTargetNum.getTargetNum();
        String s;
        while(true){
            s=Console.readLine();
            UserNum userNum= validUserNum.getValidUserNum(s);

            CountNum countNum = judgeCountNum.getJudgeCountNum(userNum,targetNum);
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

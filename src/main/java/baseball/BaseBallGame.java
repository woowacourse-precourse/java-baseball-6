package baseball;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import static baseball.Constant.*;

public class BaseBallGame {
    private List<Integer> computerNums;
    ComputerUtil computerUtil = new ComputerUtil();
    UserUtil userUtil = new UserUtil();
    InputValidation inputvalidation = new InputValidation();
    public BaseBallGame(){
        System.out.println(START_MESSAGE);
    }
    public void start(){
        int gameControlNum = CONTINUE;
        computerNums = computerUtil.generateNumber();

        while (gameControlNum == CONTINUE){
            String Input = userUtil.getNumber();
            List<Integer> userNums = inputvalidation.validateNum(Input);
            Boolean result = computerUtil.compareNumber(computerNums, userNums);
            if (result){
                gameControlNum = userUtil.getControlNumber();
                inputvalidation.validateControlNumber(gameControlNum);
                if (gameControlNum == CONTINUE){
                    computerNums = computerUtil.generateNumber();
                }
            }
        }
    }

}

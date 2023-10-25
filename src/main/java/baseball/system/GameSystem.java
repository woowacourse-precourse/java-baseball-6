package baseball.system;

import baseball.numsdata.ComputerNumberManage;
import baseball.numsdata.ResultManage;
import baseball.numsdata.UserNumberManage;
import baseball.viewer.Output;
import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    public void start() {
        Output show = new Output();
        show.opening();

        boolean endGame = false;
        int state = 1;
        ComputerNumberManage randomNumber = new ComputerNumberManage();

        while(!endGame){
            if(state == 0){
                randomNumber = new ComputerNumberManage();
            }

            show.guide();
            String input = Console.readLine();
            UserNumberManage user = new UserNumberManage(input);
            user.checkNumber();

            ResultManage result = new ResultManage();
            result.gameSetResult(user.getUserNumbers(), randomNumber.getComputerNumbers());

            // delete
//            System.out.println(randomNumTemp);
//            System.out.println(userTemp);
            show.result(result.getBall(), result.getStrike());

            if(result.getStrike() == 3){
                show.decide();
                String decision = Console.readLine();
                if(decision.equals("1")){
                    state = 0;
                }
                else if(decision.equals("2")){
                    endGame = true;
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                state = 1;
            }



        }
    }
}

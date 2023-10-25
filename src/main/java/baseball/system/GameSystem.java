package baseball.system;

import baseball.numsdata.ComputerNumberManage;
import baseball.numsdata.UserNumberManage;
import baseball.viewer.Output;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

            int [] checkScore = new int[3];
            List<Integer> userTemp = user.getUserNumbers();
            List<Integer> randomNumTemp = randomNumber.getComputerNumbers();

            for(int computerNum = 0; computerNum < 3; computerNum++){
                for(int userNum = 0; userNum < 3; userNum++){
                    if(checkScore[userNum] == 2 ) continue;
                    if(randomNumTemp.get(computerNum).equals(userTemp.get(userNum)) && computerNum == userNum) {
                        checkScore[computerNum] = 2;
                        break;
                    }
                    else if(randomNumTemp.get(computerNum).equals(userTemp.get(userNum))){
                        checkScore[computerNum] = 1;
                        break;
                    }
                }
            }

            // delete
//            System.out.println(randomNumTemp);
//            System.out.println(userTemp);


            int ball = 0;
            int strike = 0;

            for(int i = 0; i < 3; i++){
                if(checkScore[i] == 1){
                    ball++;
                }
                else if(checkScore[i] == 2){
                    strike++;
                }
            }
            show.result(ball, strike);

            if(strike == 3){
                show.decide();
                String decision = Console.readLine();
                if(decision.equals("1")){
                    state = 0;
                }
                else if(decision.equals("2")){
                    endGame = true;
                }


            }
            else{
                state = 1;
            }



        }
    }
}

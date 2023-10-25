package baseball.service;

import baseball.domain.GameResult;

import java.util.ArrayList;
import java.util.List;

public class CheckService {

    public static GameResult matchNumber(List<Integer> userNum, List<Integer> computerNum){
        GameResult gameResult = new GameResult();
        int strike = 0;
        int ball = 0;

        // bit 연산?
        for(int i=0; i<userNum.size(); i++){
            for(int j=0; j<computerNum.size(); j++){
                if(userNum.get(i) == computerNum.get(j)) {   // 리팩토링 필요.
                    if(i == j)
                        strike++;
                    else if(i != j)
                        ball++;
                    break;
                }
            }
        }

        gameResult.setBall(ball);
        gameResult.setStrike(strike);

        if(strike == 3)
            gameResult.setSuccess(true);
        else if(strike != 3)
            gameResult.setSuccess(false);

        return gameResult;
    }

}

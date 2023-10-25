package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Error.*;

public class Player {
    private final List<Integer> ballList;
    Player(){
        ballList = new ArrayList<>();
        setComputerList(ballList);
    }
    Player(String playerInput){
        ballList = new ArrayList<>();
        setPlayerList(playerInput, ballList);
    }

    public void setComputerList(List<Integer> ballList){
        while(ballList.size()<numLength){
            int ranNum = Randoms.pickNumberInRange(1,9);

            if(!ballList.contains(ranNum))
                ballList.add(ranNum);
        }
    }

    public void setPlayerList(String playerInput, List<Integer> ballList){
        if(playerInput.isEmpty() || playerInput.isBlank())
            throwError(INVALID_INPUT);

        if(playerInput.length() != numLength)
            throwError(INVALID_LENGTH);

        for(int i=0; i<numLength; i++) {
            int num = playerInput.charAt(i) - '0';
            if(num<1 || num>9)
                throwError(INVALID_DIGIT);

            if(!ballList.isEmpty() && ballList.contains(num))
                throwError(DUPLICATED_NUMBER);

            ballList.add(num);
        }
    }

    public List<Integer> getBallList() {
        return this.ballList;
    }
}

package game;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game{

//  게임 재시작 여부
    private boolean restart(){
        System.out.println(ASK_RESTART_MESSAGE);
        int UserInput = Console.readLine();
        return compareRestart(UserInput);
    }
    private boolean compareRestart(int UserInput){
        if(UserInput==RESTART_GAME_NUMBER) return true;
        if(UserInput==EXIT_GAME_NUMBER) return false;
    }

}
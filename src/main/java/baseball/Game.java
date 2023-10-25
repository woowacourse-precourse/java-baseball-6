package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.system.GameSetting;

import java.util.ArrayList;

public class Game {
    public static final int DIGITS = 3;
    public static final int START_NUM = 1;
    public static final int LAST_NUM = 9;

    public static void StartGame(){
        ArrayList<Integer> userNumList;
        ArrayList<Integer> computerNumList;

        //랜덤 숫자 생성
        computerNumList = Computer.createNumber(DIGITS,START_NUM,LAST_NUM);
        //사용자 입력
        userNumList = Player.inputData(DIGITS);

        GameSetting.getGameStatus(computerNumList, userNumList);
    }
}

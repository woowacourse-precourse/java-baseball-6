package baseball.service;

import baseball.domain.PlayBaseball;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballService {
    private static final String RESTART_MENU = "1";
    private static final String GAME_END_MENU = "2";
    private PlayBaseball playBaseball;

    public void playGame(){
        this.playBaseball = new PlayBaseball();
    }

    public String getGameResult(){
        String result = "";
        if(playBaseball.getGameLaunch().getBallNum() > 0){
            result += playBaseball.getGameLaunch().getBallNum()+" ";
        }
        if(playBaseball.getGameLaunch().getStrikeNum() > 0){
            result += playBaseball.getGameLaunch().getStrikeNum();
        }
        return result;
    }

    public boolean checkMenuIsSecondMenu(String num){
        return num.equals(SECOND_MENU);
    }

    public int getUserNum(){
        return userNum;
    }



}

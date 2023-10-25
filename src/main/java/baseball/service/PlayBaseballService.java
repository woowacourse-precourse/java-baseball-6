package baseball.service;

import baseball.domain.GameScoreSet;
import baseball.domain.PlayBaseball;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballService {
    private static final String RESTART_MENU = "1";
    private static final String GAME_END_MENU = "2";
    private PlayBaseball playBaseball;

    public void playGame(){
        this.playBaseball = new PlayBaseball();
    }

    public boolean checkMenu(String inputMenu){
        return inputMenu.equals(RESTART_MENU);
    }

    public GameScoreSet showGameResult(String inputNum){
        playBaseball.inputUserNum(inputNum);
        playBaseball.gameResult();

        return playBaseball.getGameScoreSet();
    }


}

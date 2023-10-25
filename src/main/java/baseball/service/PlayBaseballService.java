package baseball.service;

import baseball.domain.GameScoreSet;
import baseball.domain.PlayBaseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        if(!validInputNum(inputNum)) throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        playBaseball.inputUserNum(inputNum);
        playBaseball.gameResult();

        return playBaseball.getGameScoreSet();
    }

    public boolean validInputNum(String inputNum){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<inputNum.length();i++){
            list.add(inputNum.charAt(i)-'0');
        }
        return inputNum.length() == 3 && list.stream().distinct().count() == 3;
    }


}

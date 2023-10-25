package baseball.domain.player;


import baseball.domain.game.GameInfo;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private int[] playerNum = new int[3];

    public void setPlayerNums(String num) {
        for(int i=0; i<3; i++) {
            playerNum[i] = Character.getNumericValue(num.charAt(i));
        }
    }

    public int[] getPlayerNums(String num) {
        return playerNum;
    }

}

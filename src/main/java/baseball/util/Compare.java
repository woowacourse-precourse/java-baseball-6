package baseball.util;

import baseball.model.ComputerNumbers;
import baseball.model.PlayerNumbers;

public class Compare {

    private int strikeCnt;
    private int ballCnt;

    public void setCnt() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public void validStrikeCnt(String playerNumber, String computerNumber) {
        for (char player : playerNumber.toCharArray()) {
            if(playerNumber.indexOf(player) == computerNumber.indexOf(player)) {
                strikeCnt++;
            }
        }
        strikeCnt++;
    }

    public void validBallCnt(String playerNumber, String computerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ballCnt++;
            }
        }



    }

}

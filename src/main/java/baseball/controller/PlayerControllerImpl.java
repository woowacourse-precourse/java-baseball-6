package baseball.controller;

import baseball.model.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayerControllerImpl implements PlayerController{
    private Player player;
    public PlayerControllerImpl(Player player) {
        this.player = player;
    }
    @Override
    public void reset(final int numberSize){
        String generatedNumber = "";
        List<Integer> usingNumbers = new ArrayList<>();
        while (usingNumbers.size() < numberSize) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!usingNumbers.contains(number)) {
                usingNumbers.add(number);
            }
        }
        for (int temp: usingNumbers) {
            generatedNumber += temp;
        }
        player.setNumber(generatedNumber);
    }
    @Override
    public int getStrikeCount(String userStr){
        int strike_count = 0;
        for (int i=0; i < userStr.length(); i++){
            if (userStr.charAt(i) == player.getNumber().charAt(i)) {
                strike_count++;
            }
        }
        return strike_count;
    }
    @Override
    public int getBallCount(String userStr){
        int ballCount = 0;
        for (int userIdx =0; userIdx < userStr.length(); userIdx++){
            for (int comIdx = 0; comIdx < userStr.length(); comIdx++){
                if (comIdx == userIdx) continue;
                if (userStr.charAt(userIdx) == player.getNumber().charAt(comIdx)) ballCount++;
            }
        }
        return ballCount;
    }
}

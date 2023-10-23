package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    //플레이어가 저장한 3개의 숫자 저장
    private List<Integer> playerNumberList;

    public PlayerNumber(){
        playerNumberList = new ArrayList<>();
    }

    //플레이어가 입력한 숫자 반환
    public List<Integer> getPlayerNumber() {
        return playerNumberList;
    }

    public void setPlayerNumber(String playerInput) {
        playerNumberList.clear();

        for(int i = 0; i <3; i++){
            char digitChar = playerInput.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            playerNumberList.add(digit);
        }
    }
}

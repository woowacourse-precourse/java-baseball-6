package baseball.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static constant.MessageList.*;
public class PlayerNumber {
    // TODO: 사용자 서로 다른 3자리 수 입력시 예외사항 처리
    private String playerNumber;

    public PlayerNumber(String playerInput){
        if (validateAll(playerInput)){
            this.playerNumber = playerInput;
        }
    }
    public String getPlayerNumber(){
        return playerNumber;
    }

    public boolean validateAll(String playerInput){
        if (validateLength(playerInput) && validateNumberRange(playerInput) && validateDuplicateNumber(playerInput)){
            return true;
        }
        return false;
    }


    public boolean validateLength(String playerNum_str){
        if (playerNum_str.length() != 3){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean validateNumberRange(String playerNum_str){
        String[] playerNum_array = playerNum_str.split("");
        int[] playerNum_array_int = new int[playerNum_array.length];

        for(int i=0; i<playerNum_array_int.length; i++){
            playerNum_array_int[i] = Integer.parseInt(playerNum_array[i]);

            if (playerNum_array_int[i] < MIN_RANGE_NUM || playerNum_array_int[i] > MAX_RANGE_NUM){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public boolean validateDuplicateNumber(String playerNum_str){
        Set<Character> playerNum_set = new HashSet<>();

        for(int i=0; i<playerNum_str.length(); i++){
            playerNum_set.add(playerNum_str.charAt(i));
        }

        if (playerNum_set.size() != playerNum_str.length()){
            throw new IllegalArgumentException();
        }

        return true;
    }
}

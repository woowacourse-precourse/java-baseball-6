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
    public void getPlayerNumber(List<Integer> numbers){
        playerNumberList = new ArrayList<>(numbers);
    }
}

package baseball.model;

import java.util.List;

public class BaseBall {
    //사용자가 input한 숫자
    private String playerNumber;

    //사용자가 input했던 숫자들
    private List<Integer> playerNumbers;


    private List<Integer> computerNumbers;

    //생성자 선언
    public void setPlayerNumber(String inputString){
        this.playerNumber = inputString.replaceAll(" ","");
    }

    public void setPlayerNumbers(List<Integer> playerNumbers){
        this.playerNumbers = playerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers){
        this.computerNumbers = computerNumbers;
    }

    public String getPlayerNumber(){
        return playerNumber;
    }

    public List<Integer> getPlayerNumbers(){
        return playerNumbers;
    }
    public List<Integer> getComputerNumbers(){
        return computerNumbers;
    }

}

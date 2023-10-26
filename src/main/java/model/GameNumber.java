package model;

import java.util.List;

/**
 * packageName    : model
 * fileName       : UserNumber
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class GameNumber {
    private String playerInput;
    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public void setPlayerInput(String inputString) {
        this.playerInput = inputString.replaceAll(" ", "");
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}

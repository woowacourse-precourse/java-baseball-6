package baseball.Model;

import java.util.List;

public class PlayNumber {
    private String InputNumber;//플레이어가 입력할 숫자에 대한 데이터
    private List<Integer> playerNumber;//플레이어가 입력한 데이터를 숫자로 변환하여 저장할 리스트
    private List<Integer> computerNumber;//컴퓨터가 나타내는 난수를 저장할 리스트

    public String getInputNumber() {
        return InputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.InputNumber = inputNumber.replaceAll(" ", "");//띄어쓰기 제거
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(List<Integer> playerNumber) {
        this.playerNumber = playerNumber;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }
}

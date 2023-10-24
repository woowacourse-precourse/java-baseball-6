package baseball.Model;

import baseball.View.Input;

public class Restart {
    private String number;
    public String getNumber() {
        return number;
    }
    public void setNumber() throws IllegalArgumentException{
        String restartNumber = Input.restartGame();
        if(!restartNumber.equals("1") && !restartNumber.equals("2")){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        this.number = restartNumber;
    }
}

package baseball.domain;

import java.util.List;

public class GameNumberDTO {
    private String userInput;
    private List<Integer> comNum;
    private List<Integer> userNum;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInputString) {
        this.userInput = userInputString;
    }

    public List<Integer> getComNum() {
        return comNum;
    }

    public void setComNum(List<Integer> comNum) {
        this.comNum = comNum;
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    public void setUserNum(List<Integer> userNum) {
        this.userNum = userNum;
    }
}


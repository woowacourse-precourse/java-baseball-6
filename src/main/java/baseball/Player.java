package baseball;

import java.util.List;

import static baseball.Reader.*;


public class Player {
    private List<Integer> userNumberList;

    public List<Integer> speakNumbers() {
        chooseNumbers();
        return userNumberList;
    }

    private void chooseNumbers() {
        this.userNumberList = readNumbers();
    }
    
    public boolean chooseFinishGame() {
        return readIsFinish();
    }
}

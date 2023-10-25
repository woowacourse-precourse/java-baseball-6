package baseball;

import java.util.List;

import static baseball.Viewer.*;


public class Player {
    private List<Integer> userNumberList;


    public List<Integer> speakNumbers() {
        chooseNumbers();
        return userNumberList;
    }

    private void chooseNumbers() {
        this.userNumberList = readNumbers();
    }
    
    public boolean speakRestart() {
        return readIsFinish();
    }
}

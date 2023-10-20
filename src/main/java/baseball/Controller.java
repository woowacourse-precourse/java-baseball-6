package baseball;

import java.util.List;

public class Controller {
    public void play() {
        List<Integer> randomNum = new RandomNum().getExistRandomNum();
        Inputview.gameStart();
        List<Integer> inputNum = Inputview.input();


    }
}

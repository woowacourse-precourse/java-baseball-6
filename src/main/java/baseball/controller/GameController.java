package baseball.controller;

import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final UserUtil userUtil = new UserUtil();
    private final RandomUtil randomUtil = new RandomUtil();

    private List<Integer> computerNumbers;

    public GameController() {
        output.printStartGame();
    }

    
}

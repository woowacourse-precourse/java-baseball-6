package baseball.Controller;

import baseball.model.ComputerNum;
import baseball.model.RestartGame;
import baseball.model.UserNum;
import baseball.util.NumberCompare;
import baseball.util.Validator;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {
    private ComputerNum computer;
    private UserNum user;
    private Validator validator;

    public GameController() {
        this.computer = new ComputerNum();
        this.validator = new Validator();
    }

    public void start() {
        do {
            user = new UserNum(Input.inputNumber());
            user.getUser();
            showCount(getNumberCompare());
            // user.initUserNum();
        } while (!isEnd());
    }

    public int[] getNumberCompare() {
        return validator.getValidator(this.computer.getComputer(), this.user.getUser());
    }

    public void showCount(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            Output.nothing();
        } else {
            if (count[0] != 0) {
                Output.ballCount(count[0]);
            }
            if (count[1] != 0) {
                Output.strikeCount(count[1]);
            }
        }

    }

    public boolean isEnd() {
        if (validator.isThreeStrike()) {
            Output.threeStrike();
            return true;
        }
        return false;
    }
}

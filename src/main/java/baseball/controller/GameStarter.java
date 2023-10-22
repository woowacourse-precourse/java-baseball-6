package baseball.controller;

import baseball.utility.Constant;
import baseball.view.Output;

public class GameStarter {

    private Output output = Output.getOutput();

    public void announceStarter() {
        String mention = Constant.GAME_START;

        output.announceMention(mention);
        inputNumber();
    }

    private void inputNumber() {

    }
}

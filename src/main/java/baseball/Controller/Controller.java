package baseball.Controller;

import baseball.view.Input;
import baseball.view.Output;

import baseball.model.RandomGenerate;

public class Controller {

    public static void run() {
        Output.Start_Message();
        Game();
    }

    public static void Game() {
        Output.Input_Message();
        Input.UserInputNumber();
    }
}
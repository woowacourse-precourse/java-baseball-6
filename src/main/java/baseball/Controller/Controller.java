package baseball.Controller;

import baseball.model.RandomGenerate;
import baseball.model.BallCount;

import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

public class Controller {

    public static String userInput;
    public static List<Integer> answer;
    public static int strikeCount;

    public static void run() {
        Output.Start_Message();
        answer = RandomGenerate.ComputerNumber();
        while (strikeCount != 3) {
            Game();
        }
        Output.Output_Message_end();
    }

    public static void Game() {
        Output.Input_Message();
        userInput = Input.UserInputNumber();
        strikeCount = BallCount.Strike(answer, userInput);
        Output.Output_Message(answer, userInput);
    }
}
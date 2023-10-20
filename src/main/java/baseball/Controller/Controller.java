package baseball.Controller;

import baseball.model.RandomGenerate;
import baseball.model.BallCount;

import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

public class Controller {

    public static String userInput;
    public static int strikeCount;

    public static void run() {
        Output.Run_Message();
        start();
    }

    public static void start() {
        List<Integer> answer = RandomGenerate.ComputerNumber();
        System.out.println(answer);
        while (strikeCount != 3) {
            Game(answer);
        }
        Output.Count_Message_end();
        Restart();
    }

    public static void Game(List<Integer> answer) {
        Output.Start_Message();
        userInput = Input.UserInputNumber();
        strikeCount = BallCount.Strike(answer, userInput);
        Output.Count_Message(answer, userInput);
    }

    public static void Restart() {
        Output.Restart_Message();
        String userRestart = Input.UserInputRestart();
        if (userRestart.equals("1")) {
            strikeCount = 0;
            start();
        }
    }
}
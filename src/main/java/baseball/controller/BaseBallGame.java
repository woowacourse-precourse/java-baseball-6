package baseball.controller;

import baseball.model.Settings;
import baseball.view.InputNumber;
import baseball.view.Output;
import java.util.List;
import java.util.Objects;

public class BaseBallGame {


    public static int restart = 0;
    public static boolean correct = false;

    public static void GameStart() {
        Output.StartMessage();

        while (!Objects.equals(Settings.restart, "2")) {
            Output.InputMessage();
            List<Integer> computer = Settings.GenerateNumbers();
            System.out.println(computer); // 확인용
            correct = false;
            while (!correct) {
                Settings.SetElements();
                String userInput = InputNumber.GetUserInput();
                CheckNumber.CheckNumberRules(userInput);
                CheckNumber.StrikesAndBalls(computer, userInput);
                Output.Hint(computer, userInput);
            }
        }
    }
}

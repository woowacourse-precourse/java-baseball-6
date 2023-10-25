package baseball.controller;

import baseball.model.GameSettings;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class BaseBallGame {


    public void GameStart() {
        Output.StartMessage();
        do {
            GameSettings.computer = GameSettings.GenerateNumbers();
            System.out.println(GameSettings.computer);
            ComparingNumbers(GameSettings.computer);
            Output.CompleteMessage();
            GameSettings.restart = CheckInput.CheckRestart(Input.GetRestartInput());
        } while (GameSettings.restart.equals("1"));
    }

    public static void ComparingNumbers(List<Integer> computer) {
        do {
            GameSettings.Init();
            Output.RequestInputMessage();
            String userInput = Input.GetUserInput();
            CheckInput.CheckNumberRules(userInput);
            ChangeInputToInt(userInput);
            CountStrike(GameSettings.user);
            CountBall(GameSettings.user);
            Output.HintMessage();
        } while (GameSettings.strike != 3);
    }

    public static void ChangeInputToInt(String userInput) {
        for (char c : userInput.toCharArray()) {
            GameSettings.user.add(c - '0');
        }
    }

    public static void CountStrike(List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (GameSettings.computer.contains(user.get(i)) && GameSettings.computer.indexOf(user.get(i)) == i) {
                GameSettings.strike++;
            }
        }
    }

    public static void CountBall(List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (GameSettings.computer.contains(user.get(i)) && GameSettings.computer.indexOf(user.get(i)) != i) {
                GameSettings.ball++;
            }
        }
    }
}
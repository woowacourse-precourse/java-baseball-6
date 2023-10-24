package baseball.controller;

import baseball.model.Settings;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class BaseBallGame {


    public static void GameStart() {
        Output.StartMessage();
        do {
            Settings.computer = Settings.GenerateNumbers();
            System.out.println(Settings.computer);
            ComparingNumbers(Settings.computer);
            Output.CompleteMessage();
            Settings.restart = CheckInput.CheckRestart(Input.GetRestartInput());
        } while (Settings.restart.equals("1"));
    }

    public static void ComparingNumbers(List<Integer> computer) {
        do {
            Settings.Init();
            Output.RequestInputMessage();
            String userInput = Input.GetUserInput();
            CheckInput.CheckNumberRules(userInput);
            ChangeInputToInt(userInput);
            CountStrike(Settings.user);
            CountBall(Settings.user);
            Output.HintMessage();
        } while (Settings.strike != 3);
    }

    public static void ChangeInputToInt(String userInput) {
        for (char c : userInput.toCharArray()) {
            Settings.user.add(c - '0');
        }
    }

    public static void CountStrike(List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (Settings.computer.contains(user.get(i)) && Settings.computer.indexOf(user.get(i)) == i) {
                Settings.strike++;
            }
        }
    }

    public static void CountBall(List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (Settings.computer.contains(user.get(i)) && Settings.computer.indexOf(user.get(i)) != i) {
                Settings.ball++;
            }
        }
    }
}
package baseball.controller;

import baseball.model.Number;
import baseball.view.InputNumber;
import java.util.List;

public class BaseBallGame {
    public static int restart = 0;
    public static boolean correct = false;

    public static void GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart != 2) {
            List<Integer> computer = Number.GenerateNumbers();
            System.out.println(computer); // 확인용
            correct = false;
            while (!correct) {
                String userInput = InputNumber.getUserInput();
                CheckNumber.checkNumberRules(userInput);
                CheckNumber.strikesAndBalls(computer, userInput);
            }
        }
    }
}

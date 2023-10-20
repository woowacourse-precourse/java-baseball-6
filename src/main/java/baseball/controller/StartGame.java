package baseball.controller;

import baseball.service.GenerateRandomNum;
import baseball.service.GenerateUserNum;
import baseball.service.GuessNum;
import java.util.List;

public class StartGame {

    GenerateRandomNum generateRandomNum = new GenerateRandomNum();
    GenerateUserNum generateUserNum = new GenerateUserNum();
    RestartGame restartGame = new RestartGame();
    GuessNum guessNum = new GuessNum();


    public void start() {
        boolean startNum = true;

        while (startNum) {

            List<Integer> generatedNumbers = generateRandomNum.generateNum();
            System.out.println(generatedNumbers);

            String result = "";

            while (!result.equals("3스트라이크")) {
                result = guessNum.Confirm(generatedNumbers, generateUserNum.userInputNumbers());
                System.out.println(result);
            }
            startNum = restartGame.shouldRestart();

        }

    }
}
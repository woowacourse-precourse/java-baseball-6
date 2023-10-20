package baseball.controller;

import baseball.service.GenerateRandomNum;
import baseball.service.GenerateUserNum;
import baseball.service.GuessNum;
import java.util.List;

public class StartGame {

    private GenerateRandomNum generateRandomNum;
    private GenerateUserNum generateUserNum;
    private RestartGame restartGame;
    private GuessNum guessNum;

    public StartGame(GenerateRandomNum generateRandomNum, GenerateUserNum generateUserNum,
            RestartGame restartGame, GuessNum guessNum) {
        this.generateRandomNum = generateRandomNum;
        this.generateUserNum = generateUserNum;
        this.restartGame = restartGame;
        this.guessNum = guessNum;
    }


    public void start() {
        boolean startNum = true;

        while (startNum) {

            List<Integer> generatedNumbers = generateRandomNum.generateNum();

            String result = "";

            while (!result.equals("3스트라이크")) {
                result = guessNum.Confirm(generatedNumbers, generateUserNum.userInputNumbers());
                System.out.println(result);
            }
            startNum = restartGame.shouldRestart();

        }

    }
}
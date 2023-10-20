package baseball;


import baseball.controller.RestartGame;
import baseball.controller.StartGame;
import baseball.service.GenerateRandomNum;
import baseball.service.GenerateUserNum;
import baseball.service.GuessNum;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        GenerateRandomNum generateRandomNum = new GenerateRandomNum();
        GenerateUserNum generateUserNum = new GenerateUserNum();
        RestartGame restartGame = new RestartGame();
        GuessNum guessNum = new GuessNum();

        StartGame startGame = new StartGame(generateRandomNum, generateUserNum, restartGame,
                guessNum);
        startGame.start();
    }
}
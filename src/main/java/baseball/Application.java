package baseball;

import baseball.entity.BaseBallGame;
import baseball.entity.Hint;
import baseball.entity.Random;
import baseball.entity.UserInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        Random random = new Random();
        Hint hint = new Hint();

        BaseBallGame baseBallGame = new BaseBallGame(userInput, random, hint);
        baseBallGame.run();
    }
}

package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.RandomNumber;
import baseball.domain.UserInput;

public class GameService {
    private static final int STRING_LENGTH = 3;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int [][] ballMap = {{1, 2}, {0, 2}, {0, 1}};
    public GameSystem playGame(UserInput userInput, RandomNumber randomNumber){
        String stringUserInput = userInput.getUserInput();
        String stringRandomNumber = randomNumber.getRandomNumber();
        GameSystem gameSystem = new GameSystem();

        for (int i = 0; i < STRING_LENGTH; i++){
            int strike = checkStrike(stringUserInput.charAt(i), stringRandomNumber.charAt(i));
            int ball = checkBall(stringUserInput.charAt(i), i, strike, stringRandomNumber);
            gameSystem.setStrike(gameSystem.getStrike() + strike);
            gameSystem.setBallCount(gameSystem.getBallCount() + ball);
        }
        return gameSystem;
    }

    public int checkStrike(char userNum, char randomNum){
        if (userNum == randomNum)return 1;
        return 0;
    }

    public int checkBall(char userNum, int position, int flag, String randomNumber){
        if (flag == 1) return 0;

        int firstRandomIdx = ballMap[position][FIRST];
        int secondRandomIdx = ballMap[position][SECOND];

        return ((userNum == randomNumber.charAt(firstRandomIdx)) || (userNum == randomNumber.charAt(secondRandomIdx))) ? 1 : 0;
    }
}

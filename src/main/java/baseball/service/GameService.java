package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.RandomNumber;
import baseball.domain.UserInput;

public class GameService {
    private static final int STRING_LENGTH = 3;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final char[][] ballMap = {{'1', '2'}, {'2', '3'}, {'3', '1'}};
    public GameSystem playGame(UserInput userInput, RandomNumber randomNumber){
        String stringUserInput = userInput.getUserInput();
        String stringRandomNumber = randomNumber.getRandomNumber();
        GameSystem gameSystem = new GameSystem();

        for (int i = 0; i < STRING_LENGTH; i++){
            int strike = checkStrike(stringUserInput.charAt(i), stringRandomNumber.charAt(i));
            int ball = checkBall(stringUserInput.charAt(i), i, strike);
            gameSystem.setStrike(gameSystem.getStrike() + strike);
            gameSystem.setBallCount(gameSystem.getBallCount() + ball);
        }
        return gameSystem;
    }

    public int checkStrike(char userNum, char randomNum){
        if (userNum == randomNum)return 1;
        return 0;
    }

    public int checkBall(char userNum, int position, int flag){
        if (flag == 1) return 0;

        char firstRandomNum = ballMap[position][FIRST];
        char secondRandomNum = ballMap[position][SECOND];

        return ((userNum == firstRandomNum) || (userNum == secondRandomNum)) ? 1 : 0;
    }
}

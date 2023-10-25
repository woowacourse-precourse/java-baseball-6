package baseball;

import java.util.*;

public class NumberBaseballGame {

    public static void startGame() {
        List<Integer> computerRandomNumber = RandomThreeDigitNumberGenerator.generateRandomThreeNumber();
        int ballCount = 0;
        int strikeCount = 0;


        while(strikeCount != 3) {
            List<Integer> userGuess = UserGuessInput.getUserInput();

            ballCount = Checker.checkBallNumbers(computerRandomNumber, userGuess);
            strikeCount = Checker.checkStrikeNumbers(computerRandomNumber, userGuess);
            ballCount -= strikeCount;

            Result.showResultPrompt(ballCount, strikeCount);
        }


        //showResultPrompt싱


    }
}


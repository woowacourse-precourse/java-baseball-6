package baseball;

import data.ComputerNumber;
import data.GuessNumber;
import java.util.List;

public class BaseballGame {
    public BaseballGame(){}

    private int countBall(
            final ComputerNumber computer, final int playerNumber, final int computerNumber){
        List<Integer> computerNumbers = computer.getNumbers();
        if(computerNumbers.contains(playerNumber)
                && computerNumber != playerNumber)
            return 1;
        return 0;
    }

    private int sumBall(final ComputerNumber computer, final GuessNumber guess){
        int totalBall = 0;
        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> guessNumbers = guess.getNumbers();
        for(int index = 0; index < 3; index++){
            int currentPlayerNum = guessNumbers.get(index);
            int currentComputerNum = computerNumbers.get(index);
            totalBall += countBall(
                    computer, currentPlayerNum, currentComputerNum
            );
        }
        return totalBall;
    }
}

package baseball;

import data.ComputerNumber;
import data.GuessNumber;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public BaseballGame(){}

    private int countBall(
            final ComputerNumber computer, final int guessNumber, final int computerNumber){
        List<Integer> computerNumbers = computer.getNumbers();
        if(computerNumbers.contains(guessNumber)
                && computerNumber != guessNumber)
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
    private int countStrike(final int computerNumber,final int guessNumber){
        if(computerNumber == guessNumber)
            return 1;
        return 0;
    }

    private int sumStrike(final ComputerNumber computer, final GuessNumber guess){
        int totalStrike = 0;
        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> guessNumbers = guess.getNumbers();
        for(int index = 0; index < 3; index++){
            int currentPlayerNum = guessNumbers.get(index);
            int currentComputerNum = computerNumbers.get(index);
            totalStrike += countStrike(currentComputerNum, currentPlayerNum);
        }
        return totalStrike;
    }
    public List<Integer> count(final ComputerNumber computer, final GuessNumber guess){
        List<Integer> countList = new ArrayList<>();
        int ball = sumBall(computer, guess);
        int strike = sumStrike(computer, guess);

        countList.add(ball);
        countList.add(strike);

        return countList;
    }

}

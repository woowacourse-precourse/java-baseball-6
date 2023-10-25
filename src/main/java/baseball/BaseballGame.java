package baseball;

import camp.nextstep.edu.missionutils.Console;
import data.ComputerNumber;
import data.GuessNumber;
import utility.Command;
import utility.Input;
import utility.Printer;
import utility.ValidityChecker;

import java.util.ArrayList;
import java.util.List;

import static utility.Command.*;

public class BaseballGame {
    static BaseballGame baseballGame = new BaseballGame();
    public static BaseballGame getInstance(){
        return baseballGame;
    }
    private BaseballGame(){}
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

    public int checkRestart(final List<Integer> countResult) throws IllegalArgumentException{
        String prompt;
        int exitCommand = 0;

        if(countResult.get(1) == 3) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            prompt = Console.readLine();
            ValidityChecker.validateBaseballNumberType(prompt);
            exitCommand = Integer.parseInt(prompt);
            if(exitCommand < 1 || exitCommand > 2)
                throw new IllegalArgumentException();
        }
        return exitCommand;
    }
}

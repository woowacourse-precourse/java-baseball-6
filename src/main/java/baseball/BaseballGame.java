package baseball;

import camp.nextstep.edu.missionutils.Console;
import data.ComputerNumber;
import data.GuessNumber;
import utility.Input;
import utility.Printer;
import utility.ValidityChecker;

import java.util.ArrayList;
import java.util.List;

import static utility.Command.*;

public class BaseballGame {
    ComputerNumber computerNumber;
    GuessNumber guessNumber;
    List<Integer> countResult;
    int exitCommand = INITIALIZE;
    List<Integer> chunk;

    static BaseballGame baseballGame = new BaseballGame();
    private BaseballGame(){}
    public static BaseballGame getInstance(){
        return baseballGame;
    }

    public void run(final int[] computerInput) throws IllegalArgumentException{
        int chunkIndex = 0;

        chunk = Input.sliceToThree(computerInput, chunkIndex);
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = new ComputerNumber(chunk);
        chunkIndex++;

        while(exitCommand == INITIALIZE || exitCommand == RESTARTED) {
            if(exitCommand == RESTARTED){
                chunk = Input.sliceToThree(computerInput, chunkIndex);
                computerNumber = new ComputerNumber(chunk);
            }

            System.out.print("숫자를 입력해 주세요 : ");
            guessNumber = new GuessNumber();
            Printer.printBaseballNumber(guessNumber);
            countResult = count(computerNumber, guessNumber);
            Printer.printResult(countResult);
            exitCommand = checkRestart(countResult);

            if(exitCommand == EXIT)
                return;
        }
    }

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

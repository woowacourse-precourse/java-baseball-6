package baseball.service;

import baseball.model.BallAndStrike;
import baseball.util.Array;
import baseball.view.OutputView;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    public static int[] makeRandomNumbers(int[] arr) {
        int pickCount = 0;
        while(pickCount < arr.length){
            int pickNumber = pickNumberInRange(1, 9);
            if(!Array.checkArraysContain(arr, pickNumber)){
                arr[pickCount] = pickNumber;
                pickCount++;
            }
        }
        return arr;
    }

    public static int[] hasNumbersToArray(String line) {
        char[] chars = line.toCharArray();
        if(chars.length != 3){
            throw new IllegalArgumentException();
        }
        int[] numbers = new int[chars.length];
        int count = 0;
        for(char a : chars){
            int num = a-'0';
            if(num <= 0 || num > 9){
                throw new IllegalArgumentException();
            }
            if(Array.checkArraysContain(numbers, num)){
                throw new IllegalArgumentException();
            }
            numbers[count] = num;
            count++;
        }
        return numbers;
    }

    public static BallAndStrike matchNumbers(int[] input, int[] rand) {
        BallAndStrike ball = new BallAndStrike();
        for(int i=0; i<input.length; i++){
            int now = input[i];
            ballAndStrikeCheck(now, i, rand, ball);
        }
        return ball;
    }

    public static void ballAndStrikeCheck(int now, int index, int[] rand, BallAndStrike ball) {
        if(rand[index] == now){
            ball.addStrike();
        }
        else if(Array.checkArraysContain(rand, now)){
            ball.addBall();
        }
    }

    public static boolean hasThreeStrike(BallAndStrike ball){
        if(ball.getStrike() >= 3){
            OutputView.printThreeStrike();
            return true;
        }
        if(ball.getBall() > 0){
            OutputView.printBall(ball.getBall());
        }
        if(ball.getStrike() > 0){
            OutputView.printStrike(ball.getStrike());
        }
        if(ball.getStrike() == 0 && ball.getBall() == 0){
            OutputView.printNothing();
        }
        OutputView.printNewLine();
        return false;
    }

    public static boolean hasNewGame(String line){
        int newGame;
        try{
            newGame = Integer.parseInt(line);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(newGame != 1 && newGame != 2){
            throw new IllegalArgumentException();
        }
        if(newGame == 1){
            return true;
        }
        return false;
    }

}

package baseball.game;

import baseball.validation.ValidUserInput;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private int ballCount;
    private int strikeCount;
    private int[] userInput;

    ValidUserInput validation = new ValidUserInput();

    public Game(int size){
        String input = Console.readLine();
        userInput = validation.valid(input, size);
        ballCount = 0;
        strikeCount = 0;
    }

    public int getBallCount(){
        return ballCount;
    }

    public void incBallCount(){
        ballCount++;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

    public void incStrikeCount(){
        strikeCount++;
    }

    public int[] getUserInput(){
        return userInput;
    }
}

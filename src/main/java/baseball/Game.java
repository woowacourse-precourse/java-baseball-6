package baseball;

import java.util.HashMap;

public class Game {
    Display display;
    Computer computer;
    public Game(){
        display = new Display();
        computer = new Computer();
        display.printStartText();
    }
    public void playGame(){
        do{
            computer.initiate();
            boolean gameOver = false;
            do{
                int[] userInputs = display.getUserInput();
                int[] judgeResult = computer.judge(userInputs);
                display.printJudgeResult(judgeResult);
                gameOver = (judgeResult[1] == 3);
            }
            while(!gameOver);
            display.printGameOverText();
        }
        while(display.getRestartInput());
    }
}

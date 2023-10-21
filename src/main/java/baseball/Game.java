package baseball;

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
            computer.initComputerNumbers();
            boolean gameOver = false;
            do{
                int[] userInputs = display.getUserInput();
                int[] judgeResult = computer.getJudgeResult(userInputs);
                display.printJudgeResult(judgeResult);
                gameOver = (judgeResult[1] == 3);
            }
            while(!gameOver);
            display.printGameOverText();
        }
        while(display.getRestartInput());
    }
}

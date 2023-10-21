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
            Judgement judgeResult;
            do{
                int[] userInputs = display.getUserInput();
                judgeResult = computer.getJudgeResult(userInputs);
                judgeResult.printResult();
            }
            while(!judgeResult.isOut());
            display.printGameOverText();
        }
        while(display.getRestartInput());
    }
}

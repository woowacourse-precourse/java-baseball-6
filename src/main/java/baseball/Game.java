package baseball;

public class Game {
    private Display display;
    private Computer computer;
    public Game(){
        display = new Display();
        computer = new Computer();
        display.printStartText();
    }
    public void playGame(){
        computer.initComputerNumbers();
        Judgement judgeResult;
        do{
            int[] userInputs = display.getUserInput();
            judgeResult = computer.getJudgement(userInputs);
            judgeResult.printResult();
        }
        while(!judgeResult.isOut());
        display.printGameOverText();
    }
}

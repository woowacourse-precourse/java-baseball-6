package baseball;

public class Game {
    private InputView inputView = new InputView();
    private Computer computer;
    public Game(){
        computer = new Computer();
        OutputView.printStartText();
    }
    public void playGame(){
        computer.initComputerNumbers();
        Judgement judgeResult;
        do{
            Numbers userNumbers = inputView.getUserNumbers();
            judgeResult = computer.getJudgement(userNumbers);
            judgeResult.printResult();
        }
        while(!judgeResult.isOut());
        OutputView.printGameOverText();
    }
}

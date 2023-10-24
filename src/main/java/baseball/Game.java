package baseball;

public class Game {
    private final InputView inputView = new InputView();
    private final Computer computer = new Computer();
    public Game(){
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

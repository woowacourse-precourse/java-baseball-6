package baseball;

public class Game {
    private final InputView inputView = new InputView();
    private final Computer computer = new Computer();

    public Game(){
        OutputView.printStartText();
    }
    public void playGame(){
        computer.initComputerNumbers();
        Judgement judgement;
        do{
            Numbers userNumbers = inputView.getUserNumbers();
            judgement = computer.getJudgement(userNumbers);
            judgement.printResult();
        }
        while(!judgement.isOut());
        OutputView.printGameOverText();
    }
}

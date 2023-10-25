package baseball;


public class Game {
    private enum Status{
        START, PROGRESS, FINISH, TERMINATED
    }
    private Status status;
    private final Computer computer;
    private final Input input;
    private final Output output;

    public Game(){
        computer = new Computer();
        input = new Input();
        output = new Output();
    }

    public void init(){
        this.status = Status.START;
        output.printStartGame();
        while(this.status != Status.TERMINATED){
            playGame();
        }
    }

    private void playGame(){
        switch (this.status) {
            case START -> start();
            case PROGRESS -> progress();
            case FINISH -> finish();
        }
    }

    private void start(){
        computer.generateComputerBaseballNumber();
        this.status = Status.PROGRESS;
        progress();
    }
    private void progress(){
        output.askUserToInsertNumbers();
        UserBaseballNumber userBaseballNumber = input.getUserBaseballNumber();
        BaseballGameResult baseballGameResult = computer.makeBaseballGameResult(userBaseballNumber);
        baseballGameResult.print();
        updateGameStatus(baseballGameResult);
    }
    private void finish(){
        boolean resume = input.getResumeInput();
        if(resume){
            this.status = Status.START;
            return;
        }
        terminate();
    }
    private void terminate(){
        this.status = Status.TERMINATED;
    }
    private void updateGameStatus(BaseballGameResult baseballGameResult){
        if(baseballGameResult.isThreeStrike()) {
            this.status = Status.FINISH;
            output.askUserToResumeOrNot();
        }
    }
}

package baseball;


import java.util.List;
import java.util.Map;

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
        computer.generateRandNums();
        this.status = Status.PROGRESS;
        progress();
    }
    private void progress(){
        output.askUserToInsertNumbers();
        List<Integer> userInputList = input.getUserInputNumbers();
        Map<String, Integer> baseballResult = computer.getBaseballResult(userInputList);
        output.printBaseballResult(baseballResult);
        updateGameStatus(baseballResult);
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
    private void updateGameStatus(Map<String, Integer> baseballResult){
        if(baseballResult.get("strike") == 3) {
            this.status = Status.FINISH;
            output.askUserToResumeOrNot();
        }
    }
}

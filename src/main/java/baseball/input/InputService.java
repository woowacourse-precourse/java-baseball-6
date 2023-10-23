package baseball.input;

import baseball.umpire.AllRightAnswer;
import baseball.umpire.BaseBallUmpire;

import java.util.List;

public class InputService {
    private final ComputerInput computerInput = new ComputerInput();
    private final UserInput userInput = new UserInput();

    public void computer(){
        computerInput.create();
    }

    public List<String> getComputer(){
        return computerInput.value();
    }

    public void user(){
        userInput.create();
        userInput.checking();
    }

    public String getUser(){
        return userInput.value();
    }
}

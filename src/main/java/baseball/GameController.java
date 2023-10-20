package baseball;

public class GameController {
    private Computer computer;
    private UserInput userInput;

    GameController() {
        computer = new Computer();
        userInput = new UserInput();
    }

    public void proceedGame() {
        computer.getRandomNum();
        userInput.promptUserInput();
    }

}

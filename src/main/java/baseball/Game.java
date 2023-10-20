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
            computer.initiate();
            boolean gameOver = true;
            do{
                int[] userInputs = display.getUserInput();
                gameOver = false;
            }
            while(gameOver);
            display.printGameOverText();
        }
        while(display.getRestartInput());
    }
}

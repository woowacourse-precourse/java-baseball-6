package baseball;

public class Game {
    Display display;
    public Game(){
        display = new Display();
        display.printStartText();
    }
    public void playGame(){
        int[] userInputs = display.getUserInput();
    }
}

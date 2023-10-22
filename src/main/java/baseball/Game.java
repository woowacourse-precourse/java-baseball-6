package baseball;

public class Game {
    private Computer computer;
    private User user;
    private Hint hint;
    private boolean continueGame;

    public Game() {
        Computer computer = new Computer();
        User user = new User();
        Hint hint = new Hint();
        continueGame = true;
    }
    
}

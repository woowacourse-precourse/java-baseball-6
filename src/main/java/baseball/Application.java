package baseball;

public class Application {
    public static void main(String[] args) {
        ComputerFunction computerFunction = new ComputerFunction();
        BaseballGame game = new BaseballGame(computerFunction);
        
        game.run();
    }
}

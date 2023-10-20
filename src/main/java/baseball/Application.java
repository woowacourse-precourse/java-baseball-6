package baseball;

public class Application {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.startMessage();
        while(true) {
            Game game = new Game();
            game.game();
            if(game.getRetryCheckNumber() == 2) {
                break;
            }
        }
    }
}

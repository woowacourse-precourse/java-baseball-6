package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        Display display = new Display();
        do{
            game.playGame();
        }
        while(display.getRestartInput());

    }
}

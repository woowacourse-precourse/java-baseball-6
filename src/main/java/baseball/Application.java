package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart;
        GameManager game = new GameManager();
        do {
            game.gameInit();
            restart = game.startGames();
        }while(restart==1);
    }
}

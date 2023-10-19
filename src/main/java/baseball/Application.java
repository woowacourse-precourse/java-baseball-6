package baseball;

public class Application {
    public static void main(String[] args) {
        try{
            GameView gameView = new GameView();
            GameController gameController = new GameController(gameView);
            gameController.run();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

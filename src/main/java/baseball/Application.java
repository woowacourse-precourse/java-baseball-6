package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
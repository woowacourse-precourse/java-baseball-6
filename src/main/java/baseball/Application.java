package baseball;
public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        Player computer = new Player();
        GameManager gameManager = new GameManager(player,computer);
        //개임 시작
        gameManager.start();
    }

}

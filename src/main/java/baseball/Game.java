package baseball;

public class Game {
    private final Manager manager = new Manager();
    public void runGame(){
        do{
            manager.setOneGame();
        }while(manager.manageGame());
    }
}

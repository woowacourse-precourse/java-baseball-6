package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Computer computer = new Computer();
        Player player = new Player();
        computer.startGame(player);
    }
}
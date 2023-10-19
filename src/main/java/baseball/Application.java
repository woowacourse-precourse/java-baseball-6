package baseball;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        output.showStartMessage();
        output.showInputMessage();

        Input input = new Input();
        String playerNumber = input.readNumber();

        Player player = new Player(playerNumber);
    }
}

package baseball;

public class Game {
    private final static int numberLength = 3;

    public void start() {
        String computerNumber, playerNumber;

        Player player = new Player();
        Computer computer = new Computer();

        playerNumber = player.inputNumber(numberLength);
        computerNumber = computer.pickTargetNumber(numberLength);

        System.out.println("computerNumber = " + computerNumber);
        System.out.println("playerNumber = " + playerNumber);
    }
}

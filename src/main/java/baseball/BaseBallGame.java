package baseball;

public class BaseBallGame {

    private Computer computer;
    private Player player;

    public void play() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            System.out.print(GameMessage.NUMBER_INPUT);
            GameResult result = computer.calculateGameResult(player.getInputAnswer());
            System.out.println(result.toString());
            isGameEnd = result.isAnswer();
        }
        System.out.println(Computer.NUMBER_DIGIT.toString() + GameMessage.GAME_END);
    }

    public void init() {
        this.computer = new Computer();
    }

    public BaseBallGame(Player player) {
        this.player = player;
    }
}

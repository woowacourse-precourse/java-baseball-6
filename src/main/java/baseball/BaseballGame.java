package baseball;

public class BaseballGame {

    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final Computer computer;
    private final Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void run() {
        initiallizeGame();
        playGame();

    }

    public void initiallizeGame() {
        computer.createRandomPicks();
        player.makePicks();
    }

    public void playGame() {
        while (true) {
            computer.call(player.getPicks());
            if (computer.gameFinished(player.getPicks())) {
                System.out.println(END_MESSAGE);
                break;
            }
            player.makePicks();
        }
    }


}

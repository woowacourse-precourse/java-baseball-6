package baseball.domain;

import static baseball.constant.GameMessage.START_MESSAGE;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private int ballCount;
    private int strikeCount;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public void play() {

    }
}

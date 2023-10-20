package baseball.service;

import baseball.domain.Baseball;
import baseball.util.NumberGenerator;

public class GameService {

    private final NumberGenerator numberGenerator;

    private Baseball computer;
    private Baseball player;

    public GameService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void startGame() {
        this.computer = new Baseball(numberGenerator.generate());
        this.player = new Baseball();
    }

    public boolean isStrike() {
        return this.computer.equals(player);
    }
}

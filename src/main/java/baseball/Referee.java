package baseball;

import static baseball.Constants.NUMBER_LENGTH;

public class Referee {

    private final Computer computer;
    private final Player player;

    private Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public static Referee getInstance(Computer computer, Player player) {
        return new Referee(computer, player);
    }

    public Result judge() {
        Result result = Result.getInstance();
        for (int position = 0; position < NUMBER_LENGTH; position++) {
            int playerPositionNumber = player.getPositionNumber(position);
            if (computer.isStrike(position, playerPositionNumber)) {
                result.addStrike();
                continue;
            }
            if (computer.isBall(playerPositionNumber)) {
                result.addBall();
            }
        }
        return result;
    }

}

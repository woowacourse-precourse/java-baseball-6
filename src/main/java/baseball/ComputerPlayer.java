package baseball;

public class ComputerPlayer {

    private BaseBallNumber goalNumber;

    public ComputerPlayer(GameRule rule) {
        goalNumber = new BaseBallNumber(rule);
    }
}

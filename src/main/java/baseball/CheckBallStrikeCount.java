package baseball;

public class CheckBallStrikeCount {
    private ComputerNumbers computerNumbers;
    private PlayerNumbers playerNumbers;

    public CheckBallStrikeCount(ComputerNumbers computerNumbers, PlayerNumbers playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public void checkBallCount(ResultOfGame resultOfGame) {
        int index = 0;
        while (index < computerNumbers.size()) {
            if (playerNumbers.contains(computerNumbers.get(index))) {
                resultOfGame.update(index, "Ball");
            }
            index++;
        }
    }

    public void checkStrikeCount(ResultOfGame resultOfGame) {
        int index = 0;
        while (index < computerNumbers.size()) {
            if (resultOfGame.get(index).equals("Ball") && (playerNumbers.get(index) == computerNumbers.get(index))) {
                resultOfGame.update(index, "Strike");
            }
            index++;
        }
    }
}

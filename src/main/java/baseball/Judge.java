package baseball;

import java.util.List;


public class Judge {
    public Judge() {
    }

    public boolean judgmentFinish(Player player, Computer computer) {
        boolean isFinished = false;
        List<Integer> playerNumberList = player.getNumberList();
        List<Integer> computerNumberList = computer.getNumberList();

        int ballCount = getBallCount(playerNumberList, computerNumberList);
        int strikeCount = getStrikeCount(playerNumberList, computerNumberList);

        GameView.printResultMessage(ballCount, strikeCount);

        if (strikeCount == 3) {
            isFinished = true;
        }

        return isFinished;
    }

    private int getBallCount(List<Integer> playerNumberList, List<Integer> computerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            Integer playerNumber = playerNumberList.get(i);
            if (computerNumberList.contains(playerNumber)) {
                int playerIndex = playerNumberList.indexOf(playerNumber);
                int computerIndex = computerNumberList.indexOf(playerNumber);

                if (playerIndex != computerIndex) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private int getStrikeCount(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount++;
            }
        }
        return strikeCount;
    }


}

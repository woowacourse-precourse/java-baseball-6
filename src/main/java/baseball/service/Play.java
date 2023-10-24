package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;

import java.util.List;

public class Play {
    public void getHint(Player playerNumber, Computer computerNumber) {
        countBall(playerNumber, computerNumber);
        countStrike(playerNumber, computerNumber);
        System.out.println(printResult(playerNumber));
    }

    private void countBall(Player playerNumber, Computer computerNumber) {
        int count = 0;

        List<Integer> playerNumbers = playerNumber.getPlayerNumber().getThreeNumbers();
        List<Integer> computerNumbers = computerNumber.getComputerNumber().getThreeNumbers();

        for (int i = 0; i < playerNumbers.size(); i++) {
            int playerDigit = playerNumbers.get(i);
            int computerDigit = computerNumbers.get(i);

            if (playerDigit != computerDigit && computerNumbers.contains(playerDigit)) {
                count++;
            }
        }
        System.out.println(count);
        playerNumber.setBallCount(count);
    }

    private void countStrike(Player playerNumber, Computer computerNumber) {
        int count = 0;
        List<Integer> playerNumbers = playerNumber.getPlayerNumber().getThreeNumbers();
        List<Integer> computerNumbers = computerNumber.getComputerNumber().getThreeNumbers();

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                count++;
            }
        }
        System.out.println(count);
        playerNumber.setStrikeCount(count);
    }

    private String printResult(Player playerNumber) {
        int ballCount = playerNumber.getBallCount();
        int strikeCount = playerNumber.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        String result = "";
        if (ballCount > 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }
        System.out.println();
        return result;
    }
}

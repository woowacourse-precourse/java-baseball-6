package baseball.model;

import baseball.dto.GameResultDto;

public class StrikeBallCounter {
    private final GameResultDto gameDto;

    public StrikeBallCounter(GameResultDto gameDto) {
        this.gameDto = gameDto;
    }

    public void createStrikeBall(String playerInput, String computerNumber) {
        int localStrike = 0;
        int localBall = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            localStrike += strikeCount(playerInput, computerNumber, i);
            localBall += ballCount(playerInput, computerNumber, i);
        }
        gameDto.setStrike(localStrike);
        gameDto.setBall(localBall);
    }

    private int strikeCount(String playerInput, String computerNumber, int i) {
        int computerIndex = computerNumber.indexOf(playerInput.charAt(i));
        if (computerIndex == i) {
            return 1;
        }
        return 0;
    }

    private int ballCount(String playerInput, String computerNumber, int i) {
        int computerIndex = computerNumber.indexOf(playerInput.charAt(i));
        if (computerIndex != i && computerIndex != -1) {
            return 1;
        }
        return 0;
    }
}

package baseball.service;

import baseball.constant.NumberConstant;
import baseball.dto.PlayerGameStateDto;

public class BaseballService {

    private final String userNumber;
    private final String computerNumber;


    public BaseballService(String userNumber, String computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public PlayerGameStateDto calculateStrikeBall() {
        PlayerGameStateDto playerGameState = new PlayerGameStateDto();
        calculateStrike(playerGameState);
        calculateBall(playerGameState);
        return playerGameState;
    }

    private void calculateBall(
        PlayerGameStateDto playerGameState) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            findDifferentIndexSameNumber(playerGameState, index);
        }
    }

    private void findDifferentIndexSameNumber(PlayerGameStateDto playerGameState, int index1) {
        for (int index2 = 0; index2 < NumberConstant.INPUT_LENGTH.getNumber(); index2++) {
            if (isDifferentIndex(index1, index2) && isSameNumber(index1, index2)) {
                addBall(playerGameState);
            }
        }
    }

    private boolean isSameNumber(int index1, int index2) {
        return userNumber.charAt(index1) == computerNumber.charAt(index2);
    }

    private boolean isSameNumber(int index) {
        return userNumber.charAt(index) == computerNumber.charAt(index);
    }


    private boolean isDifferentIndex(int index1, int index2) {
        return index1 != index2;
    }

    private void addBall(PlayerGameStateDto playerGameState) {
        playerGameState.addBall();
    }

    private void calculateStrike(PlayerGameStateDto playerGameState) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            if (isSameNumber(index)) {
                addStrike(playerGameState);
            }
        }
    }

    private void addStrike(PlayerGameStateDto playerGameState) {
        playerGameState.addStrike();
    }
}

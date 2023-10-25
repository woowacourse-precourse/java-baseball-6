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

    public PlayerGameStateDto calculate() {
        PlayerGameStateDto playerGameStateDto = new PlayerGameStateDto();
        calculateStrike(playerGameStateDto);
        calculateBall(playerGameStateDto);
        return playerGameStateDto;
    }

    private void calculateBall(
        PlayerGameStateDto playerGameStateDto) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            findDifferentIndexSameNumber(playerGameStateDto, index);
        }
    }

    private void findDifferentIndexSameNumber(PlayerGameStateDto playerGameStateDto, int index1) {
        for (int index2 = 0; index2 < NumberConstant.INPUT_LENGTH.getNumber(); index2++) {
            if (isDifferentIndex(index1, index2) && isSameNumber(index1, index2)) {
                addBall(playerGameStateDto);
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

    private void addBall(PlayerGameStateDto playerGameStateDto) {
        playerGameStateDto.addBall();
    }

    private void calculateStrike(PlayerGameStateDto playerGameStateDto) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            if (isSameNumber(index)) {
                addStrike(playerGameStateDto);
            }
        }
    }

    private void addStrike(PlayerGameStateDto playerGameStateDto) {
        playerGameStateDto.addStrike();
    }
}

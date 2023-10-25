package baseball.service;

import baseball.constant.NumberConstant;
import baseball.dto.GameStateDto;

public class BaseballService {

    private final String userNumber;
    private final String computerNumber;


    public BaseballService(String userNumber, String computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public GameStateDto calculate() {
        GameStateDto gameStateDto = new GameStateDto();
        calculateStrike(gameStateDto);
        calculateBall(gameStateDto);
        return gameStateDto;
    }

    private void calculateBall(
            GameStateDto gameStateDto) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            findDifferentIndexSameNumber(gameStateDto, index);
        }
    }

    private void findDifferentIndexSameNumber(GameStateDto gameStateDto, int index1) {
        for (int index2 = 0; index2 < NumberConstant.INPUT_LENGTH.getNumber(); index2++) {
            if (isDifferentIndex(index1, index2) && isSameNumber(index1, index2)) {
                addBall(gameStateDto);
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

    private void addBall(GameStateDto gameStateDto) {
        gameStateDto.addBall();
    }

    private void calculateStrike(GameStateDto gameStateDto) {
        for (int index = 0; index < NumberConstant.INPUT_LENGTH.getNumber(); index++) {
            if (isSameNumber(index)) {
                addStrike(gameStateDto);
            }
        }
    }

    private void addStrike(GameStateDto gameStateDto) {
        gameStateDto.addStrike();
    }
}
